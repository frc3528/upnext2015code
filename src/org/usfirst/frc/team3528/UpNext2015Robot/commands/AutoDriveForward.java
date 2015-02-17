package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {
    
    public  AutoDriveForward() {
    	
    	addSequential(new SetBrakeMode());
    	addSequential(new ZeroEncoders());
    	//addSequential(new DriveByFeet(10.0, 15.0, 0.5));
    	addSequential(new ALilTwist());
    	addSequential(new ZeroEncoders());
    }
}