package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickUpBin extends Command {

	double armPower = -.6;
	double wristPower = -.25;
	double endPower = 0;
    boolean armDown = false;
    boolean wristDown = false;
	boolean finished = false;
	
    public PickUpBin() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.runArm(armPower);
    	Robot.arm.runWrist(wristPower);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	int armPos = Robot.arm.getArmPos();
    	int wristPos = Robot.arm.getWristPos();
    	
    	if(armPos <= -1820) {
    		Robot.arm.runArm(endPower);
    		armDown = true;
    	}
    	
    	if(wristPos >= 0) {
    		Robot.arm.runWrist(endPower);
    		wristDown = true;
    	}
    	
    	if(armDown && wristDown) {
    		finished =true;
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

