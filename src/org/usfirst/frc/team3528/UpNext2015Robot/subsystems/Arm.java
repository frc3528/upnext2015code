package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;


public class Arm extends Subsystem {
    
	VictorSP arm = RobotMap.arm;

	Encoder armEncoder = RobotMap.armEncoder;
	
	DigitalInput armIn = RobotMap.armIn;
	DigitalInput armOut = RobotMap.armOut;

	
    public void runArm(double power) {
    	arm.set(power);
    }
    
    
    public void stopArm() {
    	arm.disable();
    }
    
    
    public boolean armIn() {
    	return !armIn.get();
    }
    
    
    public boolean armOut() {
    	return !armOut.get();
    }
    
    
    public int getArmPos() {
    	return armEncoder.get();
    }
    
    public void zeroArmEncoder() {
    	armEncoder.reset();
    }


	public void initDefaultCommand() {
	
	}

}

	