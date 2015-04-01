package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRecycleBin extends CommandGroup {
    
    public  AutoRecycleBin() {
    	addSequential(new SetBrakeMode());
    	addSequential(new ZeroEncoders());
    	addSequential(new PickUpFromStep());
    	addSequential(new DriveByFeetBackward(0.5, 1.0, .5));
    	addSequential(new PullBackFromStep());
    	addSequential(new DriveByFeetForward(5.0, 4.0, .55));
    	addSequential(new PickUpBin());
    }
}
