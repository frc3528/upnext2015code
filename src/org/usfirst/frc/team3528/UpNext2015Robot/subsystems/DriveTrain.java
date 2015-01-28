package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;
import org.usfirst.frc.team3528.UpNext2015Robot.Utils;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    CANTalon frontLeftMotor = RobotMap.frontLeftMotor;
    CANTalon backLeftMotor = RobotMap.backLeftMotor;
    CANTalon frontRightMotor = RobotMap.frontRightMotor;
    CANTalon backRightMotor = RobotMap.backRightMotor;
    
    RobotDrive robotDrive = RobotMap.driveTrain;
    
    Gyro gyro = RobotMap.gyro;

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());	
    }

    
    public void driveWithJoystick(Joystick joystick, Gyro gyro) {
    	//System.out.println((joystick.getTwist() * -1 + joystick.getThrottle()));//Creating "one" axis from two
    	drive(joystick.getX(), joystick.getY(), joystick.getTwist() * -1 + joystick.getThrottle(), gyro.getAngle()); //Xbox
    	//driveWithJoystick(joystick.getX(), joystick.getY(), joystick.getThrottle(), 0); //Flight Stick
    	
    }
    
    
    public void drive(double x, double y, double rotation, double gyroAngle) {
    	
    	robotDrive.mecanumDrive_Cartesian(Utils.rampSpeed(x, RobotMap.SENSITIVITY), Utils.rampSpeed(y, RobotMap.SENSITIVITY), Utils.rampSpeed(1 * rotation, RobotMap.SENSITIVITY), gyroAngle); //Field Oriented
    	//robotDrive.mecanumDrive_Cartesian(Utils.rampSpeed(x, RobotMap.SENSITIVITY), Utils.rampSpeed(y, RobotMap.SENSITIVITY), Utils.rampSpeed(1 * rotation, RobotMap.SENSITIVITY), 0); //Non-Field Oriented
    	//robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0); //Non-Ramping
    
    }
    
    
    public double gyroAngle() {
    	return gyro.getAngle();
    }
    
    
    public void gyroInit(Gyro gyro) {
    	System.out.println("InitializeGyro" );
    	gyro.initGyro();
    	gyro.reset();
    }

    
    public void increaseSensitivity() {
        if(RobotMap.SENSITIVITY < .9) {
            RobotMap.SENSITIVITY += .1;
        }
    }

    
    public void decreaseSensitivity() {
        if(RobotMap.SENSITIVITY > .2) {
            RobotMap.SENSITIVITY -= .1;
        }
    }
    
    
    public void zeroEncoder(CANTalon tal) {
    	tal.setPosition(0);
    }
    
    
    public void setBrakeMode(CANTalon tal) {
    	tal.enableBrakeMode(true);
    }
    
    
    public void setCoastMode(CANTalon tal) {
    	tal.enableBrakeMode(false);
    }

	
	public double frontLeftPos() {
		return frontLeftMotor.getEncPosition();
	}

	
	public double frontRightPos() {
		return frontRightMotor.getEncPosition() * -1;
	}

	
	public double backLeftPos() {
		return backLeftMotor.getEncPosition();
	}
	
	
	public double backRightPos() {
		return backRightMotor.getEncPosition()* -1;
	}

}