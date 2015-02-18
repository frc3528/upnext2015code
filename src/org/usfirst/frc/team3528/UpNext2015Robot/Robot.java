
package org.usfirst.frc.team3528.UpNext2015Robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.*;
import org.usfirst.frc.team3528.UpNext2015Robot.subsystems.*;


public class Robot extends IterativeRobot {

	//Subsystems
	public static DriveTrain driveTrain;
	public static Elevator elevator;
	public static Arm arm;
	public static Flipper flipper;
	
	
	//Operator Interface
	public static OI oi;
	
	//Autonomous Command
    Command autonomousCommand;

    
    public void robotInit() {
		System.out.println("====> UpNext2015Robot <====");
		RobotMap.init();
		
		//Subsystems
		driveTrain = new DriveTrain();
    	elevator = new Elevator();
		arm = new Arm();
		flipper = new Flipper();
	
		//Operator Interface
		oi = new OI();
       
		//Start Gyro
		Robot.driveTrain.initGyro();
		
		RobotMap.checkForfile();
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
    	System.out.println("===TeleOp===");
    	System.out.println("elevPos:" + RobotMap.elevatorPosition);
    	new ZeroEncoders().start();
    	new SetCoastMode().start();
    	if (autonomousCommand != null) autonomousCommand.cancel();
    }

    
    public void disabledInit(){
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
