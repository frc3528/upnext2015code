package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {
    
    public  AutoDriveForward() {
    	
    	System.out.println("Hi There");
        
    	addSequential(new SetBrakeMode());
    	addSequential( new ZeroEncoders());
        addSequential(new DriveByFeet(5.0, 10.0, 0.5));
        addSequential( new ZeroEncoders());
        System.out.println("goodbye");
    }
}