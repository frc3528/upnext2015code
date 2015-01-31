package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
	VictorSP lowerArm = RobotMap.lowerArm;
	VictorSP upperArm = RobotMap.upperArm;
	Relay claw = RobotMap.clawSpike;
	Encoder lowerEncoder = RobotMap.lowerEncoder;
	Encoder upperEncoder = RobotMap.upperEncoder;
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void runUpperArm(double power) {
    	upperArm.set(power);
    }
    
    
    public void runLowerArm(double power) {
    	lowerArm.set(power);
    }
    
    
    public void closeClaw() {
    	claw.set(Value.kForward);
    }
    
    
    public void openClaw() {
    	claw.set(Value.kReverse);
    }
    
    
    public void stopClaw() {
    	claw.set(Value.kOff);
    }
    
    
    public void zeroUpper() {
    	upperEncoder.reset();
    }


    public void zeroLower() {
    	lowerEncoder.reset();
    }
}

	