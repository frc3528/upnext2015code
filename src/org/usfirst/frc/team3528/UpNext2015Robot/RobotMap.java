package org.usfirst.frc.team3528.UpNext2015Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;



public class RobotMap {
    
	
// ======================Objects===========================
	
	//DriveTrain
	/*
	public static Talon frontLeftMotor;
	public static Talon backLeftMotor;
	public static Talon frontRightMotor;
	public static Talon backRightMotor;
	*/
	
	public static CANTalon frontLeftMotor;
	public static CANTalon backLeftMotor;
	public static CANTalon frontRightMotor;
	public static CANTalon backRightMotor;
	
	public static Gyro gyro;
	
	public static RobotDrive driveTrain;
	
	
	//Elevator
	public static VictorSP elevatorV;
	
	public static DigitalInput setPoint1;
	
	
// ======================Constants===========================
	
	//Controllers
	public static final int DRIVESTICK = 0;
	public static final int A = 1;
	public static final int BACKBUTTON = 7;
	public static final int STARTBUTTON = 8;
	
	
	//DriveTrain
	public static double SENSITIVITY = .6;
	
	public static final int DRIVE_LEFT_FRONT_TALON = 1;
	public static final int DRIVE_LEFT_BACK_TALON = 3;
	public static final int DRIVE_RIGHT_FRONT_TALON = 2;
	public static final int DRIVE_RIGHT_BACK_TALON = 4;
	
	public static final int GYRO = 0;
	
	
	// ********** Wheels and Encoders and Distance Oh My **********
	
	// Wheel Size
	public static final double WHEEL_DIAMETER = 8.0;
	
	// Calculate Wheel Diameter
	public static final double INCHES_PER_REV = Math.PI * WHEEL_DIAMETER;
	
	// Encoder Counts/Ticks per one revolution
	public static final double COUNTS_PER_REV = 1440;//360;
	
	// Calculate how many inches are in one encoder count/tick
	public static final double INCHES_PER_COUNT = INCHES_PER_REV / COUNTS_PER_REV;

	// ********** And they all lived happily ever after. The End. **********
	
	
	//Elevator
	public static final int ELEVATOR_VICTOR = 0;
	
	public static final int SETPOINT1 = 0;
	
	
	public static void init() {
		//System.out.println("IN ROBOTMAP");
		
		
		
		// DriveTrain
		/*
		frontLeftMotor = new Talon(DRIVE_LEFT_FRONT_TALON);
		backLeftMotor = new Talon(DRIVE_LEFT_BACK_TALON);
		frontRightMotor = new Talon(DRIVE_RIGHT_FRONT_TALON);
		backRightMotor = new Talon(DRIVE_RIGHT_BACK_TALON);
		*/
		
		frontLeftMotor = new CANTalon(DRIVE_LEFT_FRONT_TALON);
		backLeftMotor = new CANTalon(DRIVE_LEFT_BACK_TALON);
		frontRightMotor = new CANTalon(DRIVE_RIGHT_FRONT_TALON);
		backRightMotor = new CANTalon(DRIVE_RIGHT_BACK_TALON);		
		
		
		frontLeftMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		backLeftMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		frontRightMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		backRightMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		gyro = new Gyro(GYRO);
		
		driveTrain = new RobotDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);
		
		driveTrain.setSafetyEnabled(false);
		driveTrain.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		driveTrain.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		driveTrain.setSensitivity(SENSITIVITY);
		
	
		//Elevator
		elevatorV = new VictorSP(ELEVATOR_VICTOR);
		
		setPoint1 = new DigitalInput(SETPOINT1);
		
		
	}	
}


