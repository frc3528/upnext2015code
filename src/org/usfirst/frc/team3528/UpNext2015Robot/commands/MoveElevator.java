package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.Robot;
import org.usfirst.frc.team3528.UpNext2015Robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MoveElevator extends Command {
	
	double upPower = -1.0;
	double downPower = 1.0;
	double power = 0;
	int limit;
	Elevator elevator;
	float timeout;
	float singleTimeout = 4;
	float stackTimeout = 10;
	String indicator;

    public MoveElevator() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	// grab our parent subsystem
    	elevator = Robot.elevator;
    	
    	setInterruptible(false);
    	requires(elevator);
    	
    }
    
    
    
    public MoveElevator(String indicator) {
    	this();
    	
    	// set local inidicator so we can use it later
    	this.indicator = indicator;    	
    	
    	// set default timeout
    	timeout = singleTimeout;
    	
    	if ( indicator == "up" ) {
    		power = upPower;
    		limit = 4;
    	} else if ( indicator == "down" ) {
    		power = downPower;
    		limit = 0;
    	} else if ( indicator == "stack" ) {
    		power = downPower;
    		limit = 0;
    		
    		// set stack timeout
    		timeout = stackTimeout;
    	}
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	

    	
    	// set a timeout as a safety
    	this.setTimeout(timeout);
    	
    	
    	// set skip
    	if ( indicator == "stack" ) {
    		elevator.skipAllButZero();
    	} else {    	
    		elevator.skipCurrentPosition();
    	}
    	
    	
    	/*
    	System.out.println( "------------------> in MoveElevator initialize <------------------- " );
    	System.out.println("pos: " + elevator.getElevatorPosition() );
    	System.out.println("limit: " + limit );
    	System.out.println("power: " + power );
    	System.out.println("skip: " + elevator.getSkip() );
    	System.out.println("indicator: " + indicator);
    	System.out.println();
    	*/
    	
    	
    	// move if we're not at the limit for our direction OR we're not a -1
    	if ( elevator.getElevatorPosition() != limit || elevator.getElevatorPosition() == -1 ) {
    		//System.out.println("====> moving");
    		
    		// write a -1 to our file in case we lose connection
    		elevator.writeElevatorPositionFile(-1);
    		
    		// move the elevator
    		elevator.runElevator(power);
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
    	
    	// timeout when we find a point or timeout period expires
        return elevator.getOnPoint() || this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	//System.out.println(" ......... ending ........... ");
    	
    	// stop running -- display position -- write position to file
    	elevator.runElevator(0);
    	elevator.displayElevatorPositionDashboard();
    	elevator.writeElevatorPositionFile();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
