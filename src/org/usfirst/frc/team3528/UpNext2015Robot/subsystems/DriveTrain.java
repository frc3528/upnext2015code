package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;
import org.usfirst.frc.team3528.UpNext2015Robot.Utils;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    CANTalon frontLeftMotor = RobotMap.frontLeftMotor;
    CANTalon backLeftMotor = RobotMap.backLeftMotor;
    CANTalon frontRightMotor = RobotMap.frontRightMotor;
    CANTalon backRightMotor = RobotMap.backRightMotor;
    
    AnalogGyro gyro = RobotMap.gyro;
    
    RobotDrive robotDrive = RobotMap.driveTrain;

    
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());	
    }

    
    public void driveWithJoystick(Joystick joystick, Gyro gyro) {
    	//System.out.println((joystick.getTwist() * -1 + joystick.getThrottle()));//Creating "one" axis from two
    	//drive(joystick.getX(), joystick.getY(), joystick.getTwist() * -1 + joystick.getThrottle(), gyro.getAngle()); //Xbox
    	drive(joystick.getX(), joystick.getY(), joystick.getThrottle(), gyro.getAngle()); //Flight Stick
    }
    
 
    public void drive(double x, double y, double rotation, double gyroAngle) {
    	x = (x * RobotMap.SENSITIVITY_X);
    	y = (y * RobotMap.SENSITIVITY_Y);
    	rotation = (rotation * RobotMap.SENSITIVITY_Z);
    	//robotDrive.mecanumDrive_Cartesian(Utils.rampSpeed(x, RobotMap.SENSITIVITY), Utils.rampSpeed(y, RobotMap.SENSITIVITY), Utils.rampSpeed(rotation, RobotMap.SENSITIVITY), gyroAngle); //Field Oriented
    	robotDrive.mecanumDrive_Cartesian(Utils.rampSpeed((x), RobotMap.SENSITIVITY), Utils.rampSpeed((y), RobotMap.SENSITIVITY), Utils.rampSpeed((rotation * .9), RobotMap.SENSITIVITY), 0); //Non-Field Oriented
    	//robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0); //Non-Ramping
    }

    
    public void initGyro() {
    	gyro.initGyro();
    	gyro.reset();
    }

    
    public double getGyro() {
    	return gyro.getAngle();
    }
    
    
    public void decreaseSensitivity() {
        if(RobotMap.SENSITIVITY < .9) {
            RobotMap.SENSITIVITY += .1;
        }
    }

    
    public void increaseSensitivity() {
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