package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StackOnThree extends Command {

    public StackOnThree() {
    	setInterruptible(false);
    	requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.runArm(1.0);
    	setTimeout(6.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.getArmPos() >= RobotMap.ARM_STACK_THREE|| isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.runArm(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
