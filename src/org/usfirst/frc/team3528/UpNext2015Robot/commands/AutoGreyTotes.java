package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGreyTotes extends CommandGroup {
    
    public  AutoGreyTotes() {
    	addSequential(new IncreaseSensitivity());
    	addSequential(new ZeroEncoders());
    	addSequential(new SetBrakeMode());
    	addSequential(new DriveByFeetForward(0.6, 0.5, 0.6));
    	addSequential(new DriveByFeetForward(0.1, 1.0, 0.55));
    	addParallel(new DriveByFeetForward(0.2, 0.5, 0.3));
    	addSequential(new RaiseElevatorStep());
    	addSequential(new Wait(1.0));
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeetForward(1.6, 1.0, 0.6));
    	addSequential(new DriveByFeetForward(0.1, 1.0, 0.55));
    	addParallel(new DriveByFeetForward(0.2, 0.5, 0.3));
    	addSequential(new RaiseElevatorStep());
    	addSequential(new ZeroEncoders());
    	//addSequential(new DriveByFeetBackward(2.5, 2.0, 0.6));
    	//addSequential(new ZeroEncoders());
    	//addSequential(new StrafeByFeetLeft(4.1, 3.0, 1.0));
    	//addSequential(new ZeroEncoders());
    	//addSequential(new DriveByFeetForward(1.1, 1.0, 0.6));
    	//addSequential(new RaiseElevatorStep());
    	//addSequential(new ZeroEncoders());
    	//addSequential(new DriveByFeetForward(1.5, 1.0, 0.6));
    	//addSequential(new RaiseElevatorStep());
    	//addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeetBackward(5.0, RobotMap.DRIVEFORWARDTIME, 0.75));
    	addSequential(new ALilTwistLeft());
    	addSequential(new SetCoastMode());
    }
}
