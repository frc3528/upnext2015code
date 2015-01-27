package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ZeroEncoders extends Command {

    public ZeroEncoders() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(.075);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.frontLeftMotor.setPosition(0);
    	RobotMap.backLeftMotor.setPosition(0);
    	RobotMap.frontRightMotor.setPosition(0);
    	RobotMap.backRightMotor.setPosition(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.backLeftPos() == 0 || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
