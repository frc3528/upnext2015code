package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;
import org.usfirst.frc.team3528.UpNext2015Robot.Utils;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    Talon frontLeftMotor = RobotMap.frontLeftMotor;
    Talon backLeftMotor = RobotMap.backLeftMotor;
    Talon frontRightMotor = RobotMap.frontRightMotor;
    Talon backRightMotor = RobotMap.backRightMotor;
    RobotDrive robotDrive = RobotMap.driveTrain;
    

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoystick());
        
    	
    	
    }
    
    public void driveWithJoystick(Joystick joystick) {
    	//System.out.println((joystick.getTwist() * -1 + joystick.getThrottle()));//Creating "one" axis from two
    	driveWithJoystick(joystick.getX(), joystick.getY(), joystick.getTwist() * -1 + joystick.getThrottle(), 0); //joystick.getThrottle(), 0);
    	//driveWithJoystick(joystick.getX(), joystick.getY(), joystick.getThrottle(), 0);
    	
    }
    
    public void driveWithJoystick(double x, double y, double rotation, double gyroAngle) {
    	
    	robotDrive.mecanumDrive_Cartesian(Utils.rampSpeed(x, RobotMap.SENSITIVITY), Utils.rampSpeed(y, RobotMap.SENSITIVITY), Utils.rampSpeed(1 * rotation, RobotMap.SENSITIVITY), 0);
    	
    }
    
}

