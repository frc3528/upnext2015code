
package org.usfirst.frc.team3528.UpNext2015Robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
	
	
	//Autonomous Stuff
    Command autonomousCommand;
    SendableChooser autoChooser;

    
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

		
		//AutoChooser
		//autoChooser = new SendableChooser();
		//autoChooser.addDefault("Drive Forward", new AutoDriveForward());
		//autoChooser.addObject("Recycle Bin & Tote", new AutoRecycleAndTote());
		//autoChooser.addObject("Recycle Bin or Tote", new AutoOneObject());
		//SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
		
		
		//Start Gyro
		Robot.driveTrain.initGyro();
		
		
		//Look for Elevator Position
		RobotMap.checkForFile();
    }
	
	
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	public void autonomousInit() {
        new ZeroEncoders().start();
        new SetBrakeMode().start();
        autonomousCommand = RobotMap.selectAuto();
        autonomousCommand.start();
    }

    
    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }

    
    public void teleopInit() {
    	System.out.println("===TeleOp===");
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
    	Scheduler.getInstance().run();
    }

    
    public void testInit() {
    }
    
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}