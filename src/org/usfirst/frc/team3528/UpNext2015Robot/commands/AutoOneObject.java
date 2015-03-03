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
    	addSequential(new DriveByFeet(-RobotMap.DRIVEFORWARDFEET, RobotMap.DRIVEFORWARDTIME, RobotMap.DRIVEFORWARDPOWER));//Negatives for driving backward
    	addSequential(new SetCoastMode());
    }
}
