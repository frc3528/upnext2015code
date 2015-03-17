package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoOneObject extends CommandGroup {
    
    public  AutoOneObject() {
    	addSequential(new ZeroEncoders());
    	addSequential(new SetBrakeMode());
    	addSequential(new RaiseElevatorStep());
    	addSequential(new DriveByFeetBackward(RobotMap.DRIVEFORWARDFEET, RobotMap.DRIVEFORWARDTIME, RobotMap.DRIVEFORWARDPOWER));
    	addSequential(new ALilTwistRight());
    	addSequential(new SetCoastMode());
    }
}
