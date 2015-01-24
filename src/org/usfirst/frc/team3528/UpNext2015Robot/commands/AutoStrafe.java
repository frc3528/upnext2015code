package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStrafe extends CommandGroup {
    
    public  AutoStrafe() {

    	addSequential(new SetBrakeMode());
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeetSideways(4, 6.0, 0.5));
    	addSequential(new ZeroEncoders());
    	
    }
}
