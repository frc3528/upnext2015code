package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoThreeToteStack extends CommandGroup {
    
    public  AutoThreeToteStack() {
    	
    	addSequential(new ZeroEncoders());
    	addSequential(new RaiseElevatorStep());
    	addSequential(new DriveByFeet(-3.0, 5.0, -0.4));
    	addSequential(new DriveByFeetSideways(3.0, 5.0, 0.5));
    	addSequential(new DriveByFeet(3.0, 5.0, 0.5));
    	addParallel(new DriveByFeet(0.5, 3.0, 0.5));
    	addSequential(new RaiseElevatorStep());
    	addSequential(new DriveByFeet(-3.0, 5.0, -0.4));
    	addSequential(new DriveByFeetSideways(3.0, 5.0, 0.5));
    	addSequential(new DriveByFeet(14.0, 10.0, 0.5));
    	addSequential(new LowerElevatorStep());
    	addSequential(new LowerElevatorStep());
    	addSequential(new DriveByFeet(-0.5, 2.0, -0.4));
    	
    }
}
