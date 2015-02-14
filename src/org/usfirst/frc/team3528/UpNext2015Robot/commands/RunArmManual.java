package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunArmManual extends Command {

    public RunArmManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.arm.runArm(Robot.oi.testStick.getRawAxis(1));
    	Robot.arm.runWrist(Robot.oi.testStick.getRawAxis(5));
    	Robot.arm.runClaw(Robot.oi.testStick.getRawAxis(4));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
