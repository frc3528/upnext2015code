package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

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
    	addSequential(new DriveByFeetSideways(RobotMap.STRAFEFEET, RobotMap.STRAFETIME, RobotMap.STRAFEPOWER));
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeet(RobotMap.DRIVEFORWARDFEET, RobotMap.DRIVEFORWARDTIME, RobotMap.DRIVEFORWARDPOWER));
    	addSequential(new ALilTwist());
    	addSequential(new LowerElevatorStep());
    	addSequential(new LowerElevatorStep());
    	addSequential(new SetCoastMode());
    }
}
