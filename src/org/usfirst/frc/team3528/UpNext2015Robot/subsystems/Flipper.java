package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flipper extends Subsystem {
    
	Relay flipperRelay = RobotMap.flipperRelay;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void flipperForward() {
		flipperRelay.set(Value.kForward);
	}
		
	
	public void flipperReverse() {
		flipperRelay.set(Value.kReverse);
	}
	
	
	public void flipperStop() {
		flipperRelay.set(Value.kOff);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

