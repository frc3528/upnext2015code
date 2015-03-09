package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StoreArm extends Command {

	double armPower = -1.0;
    
	public StoreArm() {
        // Use requires() here to declare subsystem dependencies
    	setInterruptible(false);
		requires(Robot.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.runArm(armPower);
    	setTimeout(9.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.armIn() || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.stopArm();
    	Robot.arm.zeroArmEncoder();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
