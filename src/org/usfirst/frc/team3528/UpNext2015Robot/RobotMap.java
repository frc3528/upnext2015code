package org.usfirst.frc.team3528.UpNext2015Robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;


public class RobotMap {
    
	
//======================Objects===========================\\
	
	
	//DriveTrain
	public static CANTalon frontLeftMotor;
	public static CANTalon backLeftMotor;
	public static CANTalon frontRightMotor;
	public static CANTalon backRightMotor;
	
	public static Gyro gyro;
	
	public static RobotDrive driveTrain;
	
	
	//Elevator
	public static VictorSP elevatorV;
	
	public static DigitalInput setPoint0;
	public static DigitalInput setPoint1;
	public static DigitalInput setPoint2;
	public static DigitalInput setPoint3;
	public static DigitalInput setPoint4;
	
	public static int elevatorPosition = 0;
	
	
	// Arm
	public static VictorSP arm;
	public static VictorSP wrist;
	
	public static Talon claw;
	
	public static Encoder armEncoder;
	public static Encoder wristEncoder;
	
	public static DigitalInput clawLimit;
	public static DigitalInput armZero;
	public static DigitalInput wristZero;
	
	public static int flipperPos = 0;
	
	// Flipper
	public static Relay flipperRelay;
	
	
//======================Constants===========================\\
	
	
	//Controllers
	public static final int CONTROLSTICK = 1;
	public static final int DRIVESTICK = 0;
	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int BACKBUTTON = 7;
	public static final int STARTBUTTON = 8;
	public static final int LEFTTRIGGER = 5;
	public static final int RIGHTTRIGGER = 6;
	public static final int LEFTSTICKCLICK = 10;	
	
	
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
	
	public static final int SETPOINT0 = 0;
	public static final int SETPOINT1 = 1;
	public static final int SETPOINT2 = 2;
	public static final int SETPOINT3 = 3;
	public static final int SETPOINT4 = 4;
	
	
	//Arm
	public static final int ARM = 2;
	public static final int WRIST = 3;
	public static final int CLAW = 1;
	
	public static final int ARM_ENCODER_A = 5;  
	public static final int ARM_ENCODER_B = 6;
	public static final int WRIST_ENCODER_A =7;
	public static final int WRIST_ENCODER_B = 8;
	
	public static final int CLAW_LIMIT = 9;
	public static final int ARM_ZERO = 10;
	public static final int WRIST_ZERO = 11;
	
	//Flipper
	public static final int FLIPPER_RELAY = 1;
	
	
//===================InitializeMap===================\\
	public static void init() {
		//System.out.println("IN ROBOTMAP");
		
		
		// DriveTrain
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
		
		setPoint0 = new DigitalInput(SETPOINT0);
		setPoint1 = new DigitalInput(SETPOINT1);
		setPoint2 = new DigitalInput(SETPOINT2);
		setPoint3 = new DigitalInput(SETPOINT3);
		setPoint4 = new DigitalInput(SETPOINT4);
		

		//Arm
		arm = new VictorSP(ARM);
		wrist = new VictorSP(WRIST);
		claw = new Talon(CLAW);
		
		armEncoder = new Encoder(ARM_ENCODER_A, ARM_ENCODER_B);
		wristEncoder = new Encoder(WRIST_ENCODER_A, WRIST_ENCODER_B);
		
		clawLimit = new DigitalInput(CLAW_LIMIT);
		armZero = new DigitalInput(ARM_ZERO);
		wristZero = new DigitalInput(WRIST_ZERO);		
		
		
		//Flipper
		flipperRelay = new Relay(FLIPPER_RELAY);
	}	
}


