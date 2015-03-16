package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {
    
    public  AutoDriveForward() {
    	
    	addSequential(new SetBrakeMode());
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeet(-RobotMap.DRIVEFORWARDFEET, RobotMap.DRIVEFORWARDTIME, RobotMap.DRIVEFORWARDPOWER));
    	addSequential(new ALilTwistRight());
    }
}