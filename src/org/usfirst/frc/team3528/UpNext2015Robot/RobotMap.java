package org.usfirst.frc.team3528.UpNext2015Robot;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;



public class RobotMap {
    
	
// Objects
	
	public static Talon frontLeftMotor;
	public static Talon backLeftMotor;
	public static Talon frontRightMotor;
	public static Talon backRightMotor;
	
	public static RobotDrive driveTrain;
	
	
	
	
// Constants
	
	public static double SENSITIVITY = .5;
	
	public static final int DRIVE_LEFT_FRONT_TALON = 3;
	public static final int DRIVE_LEFT_BACK_TALON = 2;
	public static final int DRIVE_RIGHT_FRONT_TALON = 1;
	public static final int DRIVE_RIGHT_BACK_TALON = 0;
	
	public static void init() {
		
		frontLeftMotor = new Talon(DRIVE_LEFT_FRONT_TALON);
		backLeftMotor = new Talon(DRIVE_LEFT_BACK_TALON);
		frontRightMotor = new Talon(DRIVE_RIGHT_FRONT_TALON);
		backRightMotor = new Talon(DRIVE_RIGHT_BACK_TALON);
		
		driveTrain = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
		
		driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		
		
	}
	
	
}


