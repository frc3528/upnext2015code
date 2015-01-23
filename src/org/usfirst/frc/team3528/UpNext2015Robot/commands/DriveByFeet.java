package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;


/**
 *
 * @author TeamUPNext
 */
public class DriveByFeet extends Command {
    
    private double distance = 0;
    private double encoderCounts = 0;
    private double power = .0;
    private double currentFrontRight = 0;
    private double currentFrontLeft = 0;
    private double newFrontRight = 0;
    private double newFrontLeft = 0;
    private double timeout = 0;
    
    
    public DriveByFeet(double distance, double timeout, double power) {
        
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        
        // grab distance and convert from feet to inches
        this.distance = distance * 12;
        this.power = power;
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	// calculate the number of encoderCounts to drive
        encoderCounts =  distance / RobotMap.INCHES_PER_COUNT;
        
        // get our initial positions (just in case ZeroEncoders command didn't work)
        currentFrontLeft = Robot.driveTrain.frontLeftPos();
        currentFrontRight = Robot.driveTrain.frontRightPos();
         newFrontLeft = currentFrontLeft;
        //newFrontRight = currentFrontRight;
        
        Robot.driveTrain.drive(0, -power, 0, 0);
        
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double leftPos = Robot.driveTrain.frontLeftPos();
    	double rightPos = Robot.driveTrain.frontRightPos();
    	
    	newFrontLeft = leftPos - currentFrontLeft;
    	newFrontRight = rightPos - currentFrontRight;
    	
    	currentFrontLeft = leftPos;
    	currentFrontRight = rightPos;
    	
    	encoderCounts = encoderCounts + currentFrontLeft;
        //encoderCounts = (encoderCounts - newFrontLeft);
        
    	/*
        Robot.driveTrain.zeroEncoder(RobotMap.frontLeftMotor);
        Robot.driveTrain.zeroEncoder(RobotMap.frontRightMotor);
        Robot.driveTrain.zeroEncoder(RobotMap.backLeftMotor);
        Robot.driveTrain.zeroEncoder(RobotMap.backRightMotor);
    	*/
    }
    
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// drive until we hit our timeout or our calculated encoder count distance
    	//System.out.println(encoderCounts);
    	return (encoderCounts <= 0 || isTimedOut());
    
    
    }
    
    
    // Called once after isFinished returns true
    protected void end() {
        encoderCounts = 0;
        currentFrontLeft = 0;
        currentFrontRight = 0;
    	newFrontLeft = 0;
    	newFrontRight = 0;
        Robot.driveTrain.drive(0, 0, 0, 0);
    }

    
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

