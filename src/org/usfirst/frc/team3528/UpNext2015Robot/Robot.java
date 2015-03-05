
package org.usfirst.frc.team3528.UpNext2015Robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3528.UpNext2015Robot.commands.*;
import org.usfirst.frc.team3528.UpNext2015Robot.subsystems.*;

import com.ni.vision.NIVision;


public class Robot extends IterativeRobot {

	//Subsystems
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	public static Arm arm;
	public static Flipper flipper;
	public static Camera camera;
	
	//Operator Interface
	public static OI oi;
	
	//Autonomous Stuff
    Command autonomousCommand;
    SendableChooser autoChooser;

    
    public void robotInit() {
		System.out.println("====> UpNext2015Robot <====");
		RobotMap.init();
		
		//AutoChooser
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Drive Forward", new AutoDriveForward());
		autoChooser.addObject("Recycle Bin & Tote", new AutoRecycleAndTote());
		autoChooser.addObject("Recycle Bin or Tote", new AutoOneObject());
		SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
		
		//Subsystems
		driveTrain = new DriveTrain();
    	elevator = new Elevator();
		arm = new Arm();
		flipper = new Flipper();
		camera = new Camera();
		
		//Operator Interface
		oi = new OI();
       
		//Start Gyro
		Robot.driveTrain.initGyro();
		
		//Look for Elevator Position
		RobotMap.checkForfile();
    }
	
	
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	public void autonomousInit() {
        new ZeroEncoders().start();
        new SetBrakeMode().start();
        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();
    }

    
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    
    public void teleopInit() {
    	System.out.println("===TeleOp===");
    	//System.out.println("elevPos:" + RobotMap.elevatorPosition);
    	new ZeroEncoders().start();
    	new SetCoastMode().start();
    	if (autonomousCommand != null) autonomousCommand.cancel();
    }

    
    public void disabledInit() {
    	Scheduler.getInstance().removeAll();
    	Robot.elevator.runElevator(0);
    	new ZeroEncoders().start();
    	new SetCoastMode().start();
    }

    
    public void teleopPeriodic() {
    	//System.out.println(Robot.arm.getWristPos() + "+" + Robot.arm.getArmPos());
    	//System.out.println(Robot.driveTrain.backLeftPos() + "+" + Robot.driveTrain.backRightPos());
    	Scheduler.getInstance().run();
    }

    
    public void testInit() {
    }
    
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
