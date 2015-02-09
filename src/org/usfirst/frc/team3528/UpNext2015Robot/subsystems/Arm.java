package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
    
	VictorSP arm = RobotMap.arm;
	VictorSP wrist = RobotMap.wrist;
	Talon claw = RobotMap.claw;
	Encoder armEncoder = RobotMap.armEncoder;
	Encoder wristEncoder = RobotMap.wristEncoder;
	DigitalInput clawLimit = RobotMap.clawLimit;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void runArm(double power) {
    	arm.set(power);
    }
    
    
    public void runWrist(double power) {
    	wrist.set(power);
    }
    
    
    public void closeClaw() {
    	claw.set(.5);
    }
    
    
    public void openClaw() {
    	claw.set(-.5);
    }
    
    
    public void stopClaw() {
    	claw.set(0);
    }
    
    
    public boolean clawLimit() {
    	return clawLimit.get();
    }
    
    public int getArmPos() {
    	return armEncoder.get();
    }
    
    
    public int getWristPos() {
    	return wristEncoder.get();
    }
    
    
    public void zeroArmEncoder() {
    	armEncoder.reset();
    }


    public void zeroWristEncoder() {
    	wristEncoder.reset();
    }
}

	