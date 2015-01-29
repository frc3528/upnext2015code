
package org.usfirst.frc.team3528.UpNext2015Robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.*;
import org.usfirst.frc.team3528.UpNext2015Robot.subsystems.*;


public class Robot extends IterativeRobot {

	public static Camera camera;
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	public static OI oi;
	public static Flipper flipper;
	public static Herders herders;

    Command autonomousCommand;

    
    public void robotInit() {
		System.out.println("====> UpNext2015Robot <====");
		RobotMap.init();
		flipper = new Flipper();
		herders = new Herders();
		camera = new Camera();
		driveTrain = new DriveTrain();
    	elevator = new Elevator();
		oi = new OI();
        driveTrain.gyroInit(RobotMap.gyro);
        autonomousCommand = new DetectTote();
    }
	
	
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	public void autonomousInit() {
        // schedule the autonomous command (example)
        new ZeroEncoders().start();
        new SetBrakeMode().start();
		if (autonomousCommand != null) autonomousCommand.start();
    }

    
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    
    public void teleopInit() {
    	new ZeroEncoders().start();
    	new SetCoastMode().start();
    	if (autonomousCommand != null) autonomousCommand.cancel();
    }

    
    public void disabledInit(){
    	new ZeroEncoders().start();
    	new SetCoastMode().start();
    	RobotMap.elevatorPosition = 0;

    }

    
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    }
    
   
    public void testPeriodic() {
        LiveWindow.run();
    }
}
