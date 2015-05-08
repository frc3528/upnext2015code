package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StackBinOnFour extends CommandGroup {
    
    public  StackBinOnFour() {
        // Add Commands here:
    	addSequential(new ZeroEncoders());
    	addSequential(new SetBrakeMode());
    	addSequential(new DriveByFeetForward(0.5, 1.0, 0.5));
    	addSequential(new Wait(1.0));
    	addSequential(new ZeroEncoders());
    	addParallel(new DriveByFeetForward(0.8, 1.0, 0.43));
    	addSequential(new StackBin());
    	addSequential(new SetCoastMode());
    }
}
