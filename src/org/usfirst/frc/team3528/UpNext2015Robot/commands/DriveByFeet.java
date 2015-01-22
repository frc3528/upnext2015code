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
    private double inches = 0;
    private double power = .0;
    private double initialFrontRight = 0;
    private double initialFrontLeft = 0;
    private double initialBackRight = 0;
    private double initialBackLeft = 0;
    private double angle = 0;
    private double timeout = 0;
    
    
    public DriveByFeet(double distance, double timeout, double power) {
    	System.out.println(" BOOO! ");
        
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        
        // grab distance and convert from feet to inches
        this.distance = distance * 12;
        
        this.power = power;
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	
    	
    	System.out.println("i'm here!  --> " + distance);
    	
    	// calculate the number of encoderCounts to drive
        encoderCounts =  distance / RobotMap.INCHES_PER_COUNT;
    
        
        // get our initial positions (just in case ZeroEncoders command didn't work)
        initialFrontRight = Robot.driveTrain.frontLeftPos();
        initialFrontLeft = Robot.driveTrain.backLeftPos();
        initialBackRight = Robot.driveTrain.frontRightPos();
        initialBackLeft = Robot.driveTrain.backRightPos();
    
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    	angle = Robot.driveTrain.gyro();
        Robot.driveTrain.drive(0, -power, 0.0, 0); //Math.abs(angle) > 5 ? angle/360 : 0 );
        
        //System.out.println("FR = " + Robot.driveTrain.frontRightPos());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	// drive until we hit our timeout or our calculated encoder count distance
        //System.out.println( Robot.driveTrain.frontRightPos() + " : " + initialFrontRight + " : " + encoderCounts );
    	return ( ( (Robot.driveTrain.frontRightPos() - initialFrontRight) >= encoderCounts ) || isTimedOut() );
    
    
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.driveTrain.drive(0, 0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

