package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ResetElevator extends Command {

	double setPower = 1.0;
	
    public ResetElevator() {
        // Use requires() here to declare subsystem dependencies
    	setInterruptible(false);
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	if(RobotMap.elevatorPosition != 0) {
    		Robot.elevator.runElevator(setPower);
    	} 
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.elevator.getPoint4()) {
    		RobotMap.elevatorPosition = 4;
    		RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    	}
    	
    	if(Robot.elevator.getPoint3()) {
    		RobotMap.elevatorPosition = 3;
    		RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    	}
    
    	if(Robot.elevator.getPoint2()) {
    		RobotMap.elevatorPosition = 2;
    		RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    	}
    
    	if(Robot.elevator.getPoint1()) {
    		RobotMap.elevatorPosition = 1;
    		RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    	}
    
    	if(Robot.elevator.getPoint0()) {
    		RobotMap.elevatorPosition = 0;
    		RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    	}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getPoint0() || RobotMap.elevatorPosition == 0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("ending");
    	RobotMap.elevatorPosition = 0;
    	Robot.elevator.runElevator(0);
    	RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("reset Interrupted");
    }
}
