package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoThreeToteStack extends CommandGroup {
    
    public  AutoThreeToteStack() {
    	
    	addSequential(new ZeroEncoders());
    	addSequential(new SetBrakeMode());
    	addSequential(new RaiseElevatorStep());//one second
    	addSequential(new ALilTwistLeft());//one second
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeetBackward(4.0, 5.0, 0.75));//two seconds
    	addSequential(new ALilTwistRight());//one second
    	addSequential(new ZeroEncoders());
    	addParallel(new DriveByFeetForward(1.0, 0.5, 0.5));//half a second
    	addSequential(new RaiseElevatorStep());//one second
    	addSequential(new DriveByFeetBackward(1.0, 0.5, 0.5));//half a second
    	addSequential(new ALilTwistLeft());//one second
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeetBackward(4.0, 5.0, 0.75));//two seconds
    	addSequential(new ALilTwistRight());//one seconds
    	addSequential(new ZeroEncoders());
    	addParallel(new DriveByFeetForward(1.0, 0.5, 0.5));//half a second
    	addSequential(new RaiseElevatorStep());//one second
    	addSequential(new ZeroEncoders());
    	addSequential(new DriveByFeetBackward(RobotMap.DRIVEFORWARDFEET, RobotMap.DRIVEFORWARDTIME, RobotMap.DRIVEFORWARDPOWER));//two and a half seconds
    	addSequential(new ALilTwistRight());//one second
    	addSequential(new ResetElevator());//three seconds
    	addSequential(new DriveByFeetBackward(1.0, 0.5, 0.5));//half a second
    	addSequential(new SetCoastMode());
    	
    }
}
