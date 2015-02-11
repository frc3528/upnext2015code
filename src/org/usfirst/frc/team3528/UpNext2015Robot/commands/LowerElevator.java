package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerElevator extends Command {

	double setPower = 1.0;
	boolean finished = false;
	
    public LowerElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(RobotMap.elevatorPosition > 0) {
    		Robot.elevator.runElevator(setPower);
    	
    	}
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.elevator.getPoint0()) {
    		finished = true;
    	}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.elevatorPosition = 0;
    	Robot.elevator.runElevator(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
