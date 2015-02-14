package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseElevatorStep extends Command {
	
	double setPower = -1.0;
	boolean finished = false;
	
	
    public RaiseElevatorStep() {
        // Use requires() here to declare subsystem dependencies
    	setInterruptible(false);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (RobotMap.elevatorPosition < 4) {
    		Robot.elevator.runElevator(setPower);
    	}
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	switch(RobotMap.elevatorPosition) {
    	case 0:
    		if (Robot.elevator.getPoint1()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	case 1:
    		if (Robot.elevator.getPoint2()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	case 2:
    		if (Robot.elevator.getPoint3()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	case 3:
    		if (Robot.elevator.getPoint4()) {
    			Robot.elevator.runElevator(0);
    			finished = true;
    		}
    		break;
    	case 4:
    		Robot.elevator.runElevator(0);
    		finished = true;
    		break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("ending");
    	if (RobotMap.elevatorPosition <= 3) {
    		RobotMap.elevatorPosition++;
    	}
    	RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("raise interrupted");
    }
}
