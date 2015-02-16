package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRecycleAndTote extends CommandGroup {
    
    public  AutoRecycleAndTote() {
    	addSequential(new RaiseElevatorStep());
    	addSequential(new RaiseElevatorStep());
    	addSequential(new RaiseElevatorStep());
    	addSequential(new DriveByFeetSideways(1.9, 2.0, 5.0));
    }
}
