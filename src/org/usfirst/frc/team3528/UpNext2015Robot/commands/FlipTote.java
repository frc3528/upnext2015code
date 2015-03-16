package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FlipTote extends Command {

	double timeout = .6;
	
	
    public FlipTote() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (Robot.oi.controlStick.getRawAxis(3) >= .6 && RobotMap.flipperPos <= 0) { 
    		Robot.flipper.flipperForward();
    		RobotMap.flipperPos++;
    		}
    
    	if (Robot.oi.controlStick.getRawAxis(2) >= .6 && RobotMap.flipperPos >= 0) {
    		Robot.flipper.flipperReverse();
    		RobotMap.flipperPos--;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.flipper.flipperStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
