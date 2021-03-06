package org.usfirst.frc.team3528.UpNext2015Robot;


import org.usfirst.frc.team3528.UpNext2015Robot.commands.AutoDoNothing;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.AutoDriveForward;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.AutoGreyTotes;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.AutoOneObject;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class RobotMap {
    

//======================Objects===========================\\
	
	
	//DriveTrain
	public static CANTalon frontLeftMotor;
	public static CANTalon backLeftMotor;
	public static CANTalon frontRightMotor;
	public static CANTalon backRightMotor;
	
	public static AnalogGyro gyro;
	
	public static RobotDrive driveTrain;
	
	
	//Elevator
	public static VictorSP elevatorV;
	
	public static DigitalInput setPoint0;
	public static DigitalInput setPoint1;
	public static DigitalInput setPoint2;
	public static DigitalInput setPoint3;
	public static DigitalInput setPoint4;
	
	
	//Arm
	public static VictorSP arm;
	public static Encoder armEncoder;	
	public static DigitalInput armIn;
	public static DigitalInput armOut;
	
	
	//Camera
	public static CameraServer server;
	
	
//======================Constants===========================\\
	
	
	//Controllers
	public static final int CONTROLSTICK = 1;
	public static final int DRIVESTICK = 0;
	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int LEFTTRIGGER = 5;
	public static final int RIGHTTRIGGER = 6;
	public static final int BACKBUTTON = 7;
	public static final int STARTBUTTON = 8;
	public static final int LEFTSTICKCLICK = 9;
	public static final int RIGHTSTICKCLICK = 10;
	
	public static final int TESTSTICK = 5;

	
	//DriveTrain
	public static double SENSITIVITY = .8;
	
	//public static final double SENSITIVITY_X = 1;
	//public static final double SENSITIVITY_Y = 1;
	//public static final double SENSITIVITY_Z = 1;
	
	// Sensitivity Variables
	public static double SENSITIVITY_X = 1;
	public static double SENSITIVITY_Y = 1;
	public static double SENSITIVITY_Z = 1;
	
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
	
	// Auto Stuff \\
	public static final double DRIVEFORWARDPOWER = 0.75;
	public static final double DRIVEFORWARDTIME = 8.0;
	public static final double DRIVEFORWARDFEET = 5.0;
	public static final double SHORTDRIVEFEET = 0.3;
	
	public static final double STRAFEPOWER = 0.5;
	public static final double STRAFETIME = 2.0;
	public static final double STRAFEFEET = 1.4;
	
	
	//Elevator
	public static final int ELEVATOR_VICTOR = 0;
	
	public static final int SETPOINT0 = 0;
	public static final int SETPOINT1 = 1;
	public static final int SETPOINT2 = 2;
	public static final int SETPOINT3 = 3;
	public static final int SETPOINT4 = 4;
	
	
	//Arm
	public static final int ARM = 2;
	
	public static final int ARM_ENCODER_A = 5; 
	public static final int ARM_ENCODER_B = 6;

	public static final int ARM_STEP_PICK_UP = 1595;
	public static final int ARM_STEP_PULL = 1334;
	public static final int ARM_STACK_FOUR = 695;
	public static final int ARM_STACK_THREE = 1247;
	
	public static final int ARM_IN = 7;
	public static final int ARM_OUT = 8;
	

	
//===================InitializeMap===================\\
	public static void init() {
			
		
		// DriveTrain
		frontLeftMotor = new CANTalon(DRIVE_LEFT_FRONT_TALON);
		backLeftMotor = new CANTalon(DRIVE_LEFT_BACK_TALON);
		frontRightMotor = new CANTalon(DRIVE_RIGHT_FRONT_TALON);
		backRightMotor = new CANTalon(DRIVE_RIGHT_BACK_TALON);		
		
		frontLeftMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		backLeftMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		frontRightMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		backRightMotor.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);

		gyro = new AnalogGyro(GYRO);
		
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
		
		armEncoder = new Encoder(ARM_ENCODER_A, ARM_ENCODER_B);
		
		armIn = new DigitalInput(ARM_IN);
		armOut = new DigitalInput(ARM_OUT);
		
		
		//Camera
		server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
	}	

	
	
	
	public static Command selectAuto() {
	if (SmartDashboard.getBoolean("DB/Button 0")) {
		//System.out.println("0");	
		return new AutoDoNothing(); 
	} else if (SmartDashboard.getBoolean("DB/Button 1")) {
		//System.out.println("1");
		return new AutoDriveForward();
	} else if (SmartDashboard.getBoolean("DB/Button 2")) {
		//System.out.println("2");
		return new AutoOneObject();
	} else if (SmartDashboard.getBoolean("DB/Button 3")) {
		//System.out.println("3");
		return new AutoGreyTotes();
	} else {
		return new AutoDoNothing();
		}
	}
}