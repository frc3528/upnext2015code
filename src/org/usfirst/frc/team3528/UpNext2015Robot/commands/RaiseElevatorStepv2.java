package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseElevatorStepv2 extends Command {
	
	double upPower = -1.0;
	Elevator elevator;

    public RaiseElevatorStepv2() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	// grab our parent subsystem
    	elevator = Robot.elevator;
    	
    	setInterruptible(false);
    	requires(elevator);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	System.out.println( "------------------> in raise initialize: --> " + elevator.getElevatorPosition() );
    	
    	elevator.setLastPosition();
    	
    	this.setTimeout(3);
    	
    	if ( elevator.getLastPosition() < 4 ) {
    		elevator.runElevator(upPower);
    	} else {
    		this.setTimeout(0);
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// read our array of points / switches / magnets
    	elevator.readElevatorPoints();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return elevator.getOnPoint() || this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	elevator.runElevator(0);
    	elevator.displayElevatorPositionDashboard();
    	elevator.writeElevatorPositionFile();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
