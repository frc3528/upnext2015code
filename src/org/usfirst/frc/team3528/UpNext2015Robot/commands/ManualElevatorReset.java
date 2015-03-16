package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ManualElevatorReset extends Command {

	boolean finished = false;
	
    public ManualElevatorReset() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	finished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.runElevator(Robot.oi.controlStick.getRawAxis(1));
    	

		if (Robot.elevator.getPoint0()) {
			Robot.elevator.runElevator(0);
			RobotMap.elevatorPosition = 0;
			RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
			SmartDashboard.putString("DB/String 0", "Position 0: XXXXX");
			SmartDashboard.putString("DB/String 1", "Position 1:");
			SmartDashboard.putString("DB/String 2", "Position 2:");
			SmartDashboard.putString("DB/String 3", "Position 3:");
			SmartDashboard.putString("DB/String 4", "Position 4:");
			finished = true;
		}

		if (Robot.elevator.getPoint1()) {
			Robot.elevator.runElevator(0);
			RobotMap.elevatorPosition = 1;
			RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
			SmartDashboard.putString("DB/String 0", "Position 0:");
			SmartDashboard.putString("DB/String 1", "Position 1: XXXXX");
			SmartDashboard.putString("DB/String 2", "Position 2:");
			SmartDashboard.putString("DB/String 3", "Position 3:");
			SmartDashboard.putString("DB/String 4", "Position 4:");
			finished = true;
		}

		if (Robot.elevator.getPoint2()) {
			Robot.elevator.runElevator(0);
			RobotMap.elevatorPosition = 2;
			RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
			SmartDashboard.putString("DB/String 0", "Position 0:");
			SmartDashboard.putString("DB/String 1", "Position 1:");
			SmartDashboard.putString("DB/String 2", "Position 2: XXXXX");
			SmartDashboard.putString("DB/String 3", "Position 3:");
			SmartDashboard.putString("DB/String 4", "Position 4:");
			finished = true;
		}

		if (Robot.elevator.getPoint3()) {
			Robot.elevator.runElevator(0);
			RobotMap.elevatorPosition = 3;
			RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
			SmartDashboard.putString("DB/String 0", "Position 0:");
			SmartDashboard.putString("DB/String 1", "Position 1:");
			SmartDashboard.putString("DB/String 2", "Position 2:");
			SmartDashboard.putString("DB/String 3", "Position 3: XXXXX");
			SmartDashboard.putString("DB/String 4", "Position 4:");
			finished = true;
		}
		
		if (Robot.elevator.getPoint4()) {
			Robot.elevator.runElevator(0);
			RobotMap.elevatorPosition = 4;
			RobotMap.writeElevatorPosition(RobotMap.elevatorPosition);
			SmartDashboard.putString("DB/String 0", "Position 0:");
			SmartDashboard.putString("DB/String 1", "Position 1:");
			SmartDashboard.putString("DB/String 2", "Position 2:");
			SmartDashboard.putString("DB/String 3", "Position 3:");
			SmartDashboard.putString("DB/String 4", "Position 4: XXXXX");
			finished = true;
		}
		//SmartDashboard.putBoolean("Position 0 ", Robot.elevator.getPoint0());
        //SmartDashboard.putBoolean("Position 1 ", Robot.elevator.getPoint1());
        //SmartDashboard.putBoolean("Position 2 ", Robot.elevator.getPoint2());
        //SmartDashboard.putBoolean("Position 3 ", Robot.elevator.getPoint3());
        //SmartDashboard.putBoolean("Position 4 ", Robot.elevator.getPoint4());
    	
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