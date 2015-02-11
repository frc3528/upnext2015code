package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerElevatorStep extends Command {

	double setPower = .2;
	boolean finished = false;
	
	
    public LowerElevatorStep() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("Left Button Pressed.");
    	if (RobotMap.elevatorPosition > 1) {
    		Robot.elevator.runElevator(setPower);
    	}
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	System.out.println(RobotMap.elevatorPosition);
    	switch(RobotMap.elevatorPosition) {
    	case 0:
    		Robot.elevator.runElevator(0);
			finished = true;
			break;
    	case 1:
    		if (Robot.elevator.getPoint0()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	case 2:
    		if (Robot.elevator.getPoint1()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	case 3:
    		if (Robot.elevator.getPoint2()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	case 4:
    		if (Robot.elevator.getPoint3()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (RobotMap.elevatorPosition >= 1) {
    		RobotMap.elevatorPosition--;
    	}
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
