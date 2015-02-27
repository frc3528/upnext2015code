package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    	setTimeout(7.0);
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
    		//SmartDashboard.putString("DB/String 0", "Position 0: XXXXX");
    		//SmartDashboard.putString("DB/String 1", "Position 1:");
    		//SmartDashboard.putString("DB/String 2", "Position 2:");
    		//SmartDashboard.putString("DB/String 3", "Position 3:");
    		//SmartDashboard.putString("DB/String 4", "Position 4:");
    		RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
    	}
    	
    	SmartDashboard.putBoolean("Position 0 ", Robot.elevator.getPoint0());
        SmartDashboard.putBoolean("Position 1 ", Robot.elevator.getPoint1());
        SmartDashboard.putBoolean("Position 2 ", Robot.elevator.getPoint2());
        SmartDashboard.putBoolean("Position 3 ", Robot.elevator.getPoint3());
        SmartDashboard.putBoolean("Position 4 ", Robot.elevator.getPoint4());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getPoint0() || RobotMap.elevatorPosition == 0 || isTimedOut();
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
