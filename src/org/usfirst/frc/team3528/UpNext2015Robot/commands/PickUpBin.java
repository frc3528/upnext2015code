package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickUpBin extends Command {

	int startingPos = 0;
	double armPower = -.6;
	double wristPower = .05;
    boolean inPosition = false;
	boolean finished = false;
	
    public PickUpBin() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.runArm(armPower);
    	Robot.arm.runWrist(wristPower);
   
    	startingPos = Robot.arm.getArmPos();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int armPos = Robot.arm.getArmPos() + startingPos;
    	
    	if(armPos <= -1800) {
    		Robot.arm.stopArm();
    		Robot.arm.stopWrist();
    		inPosition = true;
    	}
    	
    	if(inPosition) {
    		finished = true;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

