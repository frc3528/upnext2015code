package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import java.util.Comparator;
import java.util.Vector;

//import org.usfirst.frc.team3528.robot.Robot.ParticleReport;


import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Camera extends Subsystem {
	
	boolean isOn = false;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public class ParticleReport implements Comparator<ParticleReport>, Comparable<ParticleReport>{
		double PercentAreaToImageArea;
		double Area;
		double ConvexHullArea;
		double BoundingRectLeft;
		double BoundingRectTop;
		double BoundingRectRight;
		double BoundingRectBottom;
		
		
		
		public int compareTo(ParticleReport r)
		{
			return (int)(r.Area - this.Area);
		}
		
		public int compare(ParticleReport r1, ParticleReport r2)
		{
			return (int)(r1.Area - r2.Area);
		}
	};
	
	public class Scores {
		double Trapezoid;
		double LongAspect;
		double ShortAspect;
		double AreaToConvexHullArea;
	};
	
	int imaqError;
	Scores scores = new Scores();
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void detectTote() {
    	

		//read file in from disk. For this example to run you need to copy image20.jpg from the SampleImages folder to the
		//directory shown below using FTP or SFTP: http://wpilib.screenstepslive.com/s/4485/m/24166/l/282299-roborio-ftp
		//NIVision.imaqReadFile(frame, "/home/lvuser/SampleImages/image20.jpg");
		RobotMap.camera.getImage(RobotMap.frame);

		//Update threshold values from SmartDashboard. For performance reasons it is recommended to remove this after calibration is finished.

		//Threshold the image looking for yellow (tote color)
		NIVision.imaqColorThreshold(RobotMap.binaryFrame, RobotMap.frame, 255, NIVision.ColorMode.HSV, RobotMap.TOTE_HUE_RANGE, RobotMap.TOTE_SAT_RANGE, RobotMap.TOTE_VAL_RANGE);

		//Send particle count to dashboard
		int numParticles = NIVision.imaqCountParticles(RobotMap.binaryFrame, 1);

		//Send masked image to dashboard to assist in tweaking mask.
		CameraServer.getInstance().setImage(RobotMap.binaryFrame);

		//filter out small particles
		float areaMin = (float)SmartDashboard.getNumber("Area min %", RobotMap.AREA_MINIMUM);
		RobotMap.criteria[0].lower = areaMin;
		imaqError = NIVision.imaqParticleFilter4(RobotMap.binaryFrame, RobotMap.binaryFrame, RobotMap.criteria, RobotMap.filterOptions, null);

		//Send particle count after filtering to dashboard
		numParticles = NIVision.imaqCountParticles(RobotMap.binaryFrame, 1);

		if(numParticles > 0)
		{
			//Measure particles and sort by particle size
			Vector<ParticleReport> particles = new Vector<ParticleReport>();
			for(int particleIndex = 0; particleIndex < numParticles; particleIndex++)
			{
				ParticleReport par = new ParticleReport();
				par.PercentAreaToImageArea = NIVision.imaqMeasureParticle(RobotMap.binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA);
				par.Area = NIVision.imaqMeasureParticle(RobotMap.binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_AREA);
				par.ConvexHullArea = NIVision.imaqMeasureParticle(RobotMap.binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_CONVEX_HULL_AREA);
				par.BoundingRectTop = NIVision.imaqMeasureParticle(RobotMap.binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_TOP);
				par.BoundingRectLeft = NIVision.imaqMeasureParticle(RobotMap.binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_LEFT);
				par.BoundingRectBottom = NIVision.imaqMeasureParticle(RobotMap.binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_BOTTOM);
				par.BoundingRectRight = NIVision.imaqMeasureParticle(RobotMap.binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_RIGHT);
				particles.add(par);
			}
			particles.sort(null);

			//This example only scores the largest particle. Extending to score all particles and choosing the desired one is left as an exercise
			//for the reader. Note that the long and short side scores expect a single tote and will not work for a stack of 2 or more totes.
			//Modification of the code to accommodate 2 or more stacked totes is left as an exercise for the reader.
			scores.Trapezoid = TrapezoidScore(particles.elementAt(0));
			scores.LongAspect = LongSideScore(particles.elementAt(0));
			scores.ShortAspect = ShortSideScore(particles.elementAt(0));
			scores.AreaToConvexHullArea = ConvexHullAreaScore(particles.elementAt(0));
			boolean isTote = scores.Trapezoid > SCORE_MIN && (scores.LongAspect > SCORE_MIN || scores.ShortAspect > SCORE_MIN) && scores.AreaToConvexHullArea > SCORE_MIN;
			boolean isLong = scores.LongAspect > scores.ShortAspect;

		} else {
			System.out.println("No Tote Detected.");
		}
	
    }
}

