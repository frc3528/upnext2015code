package org.usfirst.frc.team3528.UpNext2015Robot.commands;


import org.usfirst.frc.team3528.UpNext2015Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickUpBin extends Command {

    public PickUpBin() {
        // Use requires() here to declare subsystem dependencies
    	setInterruptible(false);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.runArm(1.0);
    	setTimeout(9.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.armOut() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.stopArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
