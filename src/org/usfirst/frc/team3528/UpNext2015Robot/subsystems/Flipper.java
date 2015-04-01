package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Flipper extends Subsystem {
    
	//Relay flipperRelay = RobotMap.flipperRelay;
	Talon flipperTalon = RobotMap.flipperTalon;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void flipperForward() {
		//flipperRelay.set(Value.kForward);
		flipperTalon.set(1.0);
	}
		
	
	public void flipperReverse() {
		//flipperRelay.set(Value.kReverse);
		flipperTalon.set(-1.0);
	}
	
	
	public void flipperStop() {
		//flipperRelay.set(Value.kOff);
		flipperTalon.set(0.0);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

