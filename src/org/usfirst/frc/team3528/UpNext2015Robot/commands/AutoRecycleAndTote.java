package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRecycleAndTote extends CommandGroup {
    
    public  AutoRecycleAndTote() {
    	addSequential(new ZeroEncoders());
    	addSequential(new SetBrakeMode());
    	addSequential(new RaiseElevatorStep());
    	addParallel(new RaiseElevatorStep());
    	addSequential(new DriveByFeetSideways(1.4, 2.0, 0.5));
    	//addSequential(new DriveByFeet(.6, 1.0, 0.3));
    	//addSequential(new RaiseElevatorStep());
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeet(10.0, 15.0, 0.5));
    	
    	//addSequential(new LowerElevatorStep());
    	//addSequential(new LowerElevatorStep());
    }
}
