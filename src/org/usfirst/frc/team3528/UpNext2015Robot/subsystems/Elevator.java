package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
    
    VictorSP victor = RobotMap.elevatorV;
    
    DigitalInput setPoint0 = RobotMap.setPoint0;
    DigitalInput setPoint1 = RobotMap.setPoint1;
    DigitalInput setPoint2 = RobotMap.setPoint2;
	DigitalInput setPoint3 = RobotMap.setPoint3;
	DigitalInput setPoint4 = RobotMap.setPoint4;
	
	boolean[] elevatorPoints = new boolean[5];
	int skip;
	
	Path elevatorPositionFile;
	int elevatorPosition;
	boolean onPoint;
	

	
	
	public Elevator() {
		
		elevatorPositionFile = Paths.get("/home/lvuser/last_known_elevator.txt");
		elevatorPosition = readElevatorPositionFile();
		displayElevatorPositionDashboard();
		
		
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void runElevator(double power) {
    	victor.set(power);
    }
    
    
    public boolean getPoint0() {
    	return setPoint0.get();
    }
    
    
    public boolean getPoint1() { 
    	return setPoint1.get();
    }

    
    public boolean getPoint2() {
    	return setPoint2.get();
    }

    
    public boolean getPoint3() {
    	return setPoint3.get();
    }


    public boolean getPoint4() {
    	return setPoint4.get();
    }
    
    
    public void readElevatorPoints() {
    	
    	onPoint = false;
    	
    	// read our elevator points / switches / magnets and populate our array
    	elevatorPoints[0] = setPoint0.get();
    	elevatorPoints[1] = setPoint1.get();
    	elevatorPoints[2] = setPoint2.get();
    	elevatorPoints[3] = setPoint3.get();
    	elevatorPoints[4] = setPoint4.get();
    	
    	// turn our last position to false (ignore it)
    	//elevatorPoints[elevatorPosition] = false;
    	
    	// run through skipList and turn any points false in the list
    	// this is used primarily for skipping our current position
    	// and is also used for skipping a bunch of points, for example: all but 0 for stack
    	/*
    	for ( int i = 0; i < 5; i++ ) {
    		if (skipList[i]) {
    			elevatorPoints[i] = false;
    		}
    	}
    	*/
    	
    	
    	if ( skip == -1 ) {
    		// skip/mask everything except 0
    		for (int i = 1; i < 5; i++) {
    			elevatorPoints[i] = false;
    		}
    		
    	} else if ( skip >= 0 && skip <= 4 ) {
    		elevatorPoints[skip] = false;
    	}
    	
    	
    	// loop through and figure out where we are
    	for ( int i = 0; i < 5 && !onPoint; i++ ) {
    		
    		// if we have a hit on a point (true) increase count and set position
    		if ( elevatorPoints[i] ) {
    			onPoint = true;
    			elevatorPosition = i;
    		}
    	}
    }
    
    
    public void skipCurrentPosition() {
    	if ( elevatorPosition != -1 ) {
    		skip = elevatorPosition;
    	}
    }
    
    
    public void skipAllButZero() {
    	skip = -1;    	
    }
    
    
    public int getSkip() {
    	return skip;
    }
    
    
    

    public int getElevatorPosition() {
    	return elevatorPosition;
    }
    
    
    public void setElevatorPosition(int pos) {
    	writeElevatorPositionFile(pos);
    	elevatorPosition = pos;
    }
 
    
    
    public boolean getOnPoint() {    	
    	
    	return onPoint;
    }
    
    
    public boolean[] getElevatorPoints() {
    	return elevatorPoints;
    }
    
    
    
    public void displayElevatorPositionDashboard() {		
		
		for ( int i = 0; i < 5; i++ ) {
			
			if (elevatorPosition == i) {
				SmartDashboard.putString("DB/String " + i, "Position " + i + ": XXXXX");
			} else {
				SmartDashboard.putString("DB/String " + i, "Position " + i + ":");
			}
		}
		
		SmartDashboard.putString("DB/String 5", "ElevatorPosition:" + elevatorPosition);
    	
    }
    
    
    
	//Read Elevator Position File
	public int readElevatorPositionFile() {
		
		String elevatorPositionString = "";
		int readPos;
		
		checkForFile();
		
		try {
			elevatorPositionString = Files.lines(elevatorPositionFile).collect(Collectors.joining());
		} catch(IOException e) {
			System.out.println("error reading elevatorPositionFile");
			e.printStackTrace();
		} 

		try {
			readPos = Integer.parseInt(elevatorPositionString);
		} catch(NumberFormatException e) {
			System.out.println("Number Format Exception Setting to -1");
			readPos = -1;
		}
		
		return readPos;
	}


	//Write To Position File
	public void writeElevatorPositionFile(int pos) {
		
		//System.out.println("+++++++++++> writing: " + pos);
		
		
		String elevatorPositionString = "" + pos;
		
		try {
			Files.write(elevatorPositionFile, elevatorPositionString.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeElevatorPositionFile() {
		writeElevatorPositionFile( elevatorPosition );
	}
	
	
	/// see if file exists. if not, create a file with a -1 in it.
	public void checkForFile() {
		if(!Files.exists(elevatorPositionFile)) {
			try {
				Files.write(elevatorPositionFile, "-1".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
    
}

