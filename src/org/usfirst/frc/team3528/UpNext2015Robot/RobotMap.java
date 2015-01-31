package org.usfirst.frc.team3528.UpNext2015Robot;


import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.hal.CanTalonSRX;
import edu.wpi.first.wpilibj.vision.AxisCamera;



public class RobotMap {
    
	
//======================Objects===========================\\
	
	
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
	
	public static DigitalInput setPoint0;
	public static DigitalInput setPoint1;
	public static DigitalInput setPoint2;
	public static DigitalInput setPoint3;
	public static DigitalInput setPoint4;
	//public static Encoder elevatorPos;
	public static int elevatorPosition = 0;
	
	
	// Camera
	public static AxisCamera camera;
	public static Relay light;
	public static Image frame;
	public static Image binaryFrame;
	
	
	// Arm
	public static VictorSP lowerArm;
	public static VictorSP upperArm;
	public static Relay clawSpike;
	public static Encoder lowerEncoder;
	public static Encoder upperEncoder;
	
	
	// Flipper
	public static Relay flipperRelay;
	
	
//======================Constants===========================\\
	
	
	//Controllers
	public static final int CONTROLSTICK = 1;
	public static final int DRIVESTICK = 0;
	public static final int A = 1;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int BACKBUTTON = 7;
	public static final int STARTBUTTON = 8;
	public static final int LEFTTRIGGER = 5;
	public static final int RIGHTTRIGGER = 6;
	
	
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
	
	public static final int ELEVATOR_ENCODER_A = 4;
	public static final int ELEVATOR_ENCODER_B = 5;
	
	
	//Camera
	public static NIVision.Range TOTE_HUE_RANGE = new NIVision.Range(24, 49);	//Default hue range for yellow tote
	public static NIVision.Range TOTE_SAT_RANGE = new NIVision.Range(67, 255);	//Default saturation range for yellow tote
	public static NIVision.Range TOTE_VAL_RANGE = new NIVision.Range(49, 255);	//Default value range for yellow tote
	public static final double AREA_MINIMUM = 0.5; //Default Area minimum for particle as a percentage of total image area
	public static final double LONG_RATIO = 2.22; //Tote long side = 26.9 / Tote height = 12.1 = 2.22
	public static final double SHORT_RATIO = 1.4; //Tote short side = 16.9 / Tote height = 12.1 = 1.4
	public static final double SCORE_MIN = 75.0;  //Minimum score to be considered a tote
	public static final double VIEW_ANGLE = 49.4; //View angle for camera, set to Axis m1011 by default, 64 for m1013, 51.7 for 206, 52 for HD3000 square, 60 for HD3000 640x480
	public static NIVision.ParticleFilterCriteria2 criteria[] = new NIVision.ParticleFilterCriteria2[1];
	public static NIVision.ParticleFilterOptions2 filterOptions = new NIVision.ParticleFilterOptions2(0,0,1,1);
	
	
	//Arm
	public static final int LOWER_ARM = 2;
	public static final int UPPER_ARM = 3;
	public static final int WRIST_RELAY = 2;
	public static final int LOWER_ENCODER_A = 6;  
	public static final int LOWER_ENCODER_B = 7;
	public static final int UPPER_ENCODER_A = 8;
	public static final int UPPER_ENCODER_B = 9;
	
	
	//Flipper
	public static final int FLIPPER_RELAY = 1;
	
	
//===================InitializeMap===================\\
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
		
		setPoint0 = new DigitalInput(SETPOINT0);
		setPoint1 = new DigitalInput(SETPOINT1);
		setPoint2 = new DigitalInput(SETPOINT2);
		setPoint3 = new DigitalInput(SETPOINT3);
		setPoint4 = new DigitalInput(SETPOINT4);
		
		//elevatorPos = new Encoder(ELEVATOR_ENCODER_A, ELEVATOR_ENCODER_B);
		
		
		//Camera
		camera = new AxisCamera("10.35.28.11");
		light = new Relay(0);
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		binaryFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		criteria[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA, AREA_MINIMUM, 100.0, 0, 0);
		
		
		//Arm
		lowerArm = new VictorSP(LOWER_ARM);
		upperArm = new VictorSP(UPPER_ARM);
		clawSpike = new Relay(WRIST_RELAY);
		lowerEncoder = new Encoder(LOWER_ENCODER_A, LOWER_ENCODER_B);
		upperEncoder = new Encoder(UPPER_ENCODER_A, UPPER_ENCODER_B);
		
		
		//Flipper
		flipperRelay = new Relay(FLIPPER_RELAY);
		
	}	
}


