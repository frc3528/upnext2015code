package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot; 
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveByFeet extends Command {

	double distance = 0;
	double encoderCounts = 0;
	double power = 0;
	double timeout = 0;
	double startingLeftPos = 0;
	double startingRightPos = 0;
	double error = 0;
	
    public DriveByFeet(double distance, double timeout, double power) {
        
    	// Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        
        // grab distance and convert from feet to inches
        this.distance = distance * 12;
        this.power = power * -1;
        this.timeout = timeout;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	startingLeftPos = Robot.driveTrain.backLeftPos();
    	startingRightPos = Robot.driveTrain.backRightPos();
    	
    	// calculate the number of encoderCounts to drive
        encoderCounts =  distance / RobotMap.INCHES_PER_COUNT;

        encoderCounts = encoderCounts + startingLeftPos;
        
        Robot.driveTrain.autoDrive(0, power, 0, 0);
        
        setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftPos = Robot.driveTrain.backLeftPos();
    	double rightPos = Robot.driveTrain.frontRightPos();
    	error = leftPos - rightPos;
    	
    	if (error < -10 ) {
    		 Robot.driveTrain.autoDrive(0, power, 0.09, 0);
    	} 
    	
    	if (error > 10) {
    		Robot.driveTrain.autoDrive(0, power, -0.09, 0);
    	}
     }
     
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Robot.driveTrain.backLeftPos() >= encoderCounts || isTimedOut();

    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("done");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
