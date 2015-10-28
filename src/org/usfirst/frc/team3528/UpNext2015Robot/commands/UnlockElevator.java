package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UnlockElevator extends Command {
	
	Elevator elevator = Robot.elevator;
	

    public UnlockElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	setInterruptible(false);
    	requires(elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	elevator.setElevatorPosition(-1);
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
