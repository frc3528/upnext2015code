package org.usfirst.frc.team3528.UpNext2015Robot.subsystems;

import org.usfirst.frc.team3528.UpNext2015Robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {
    
    VictorSP victor = RobotMap.elevatorV;
    DigitalInput setPoint0 = RobotMap.setPoint0;
    DigitalInput setPoint1 = RobotMap.setPoint1;
    DigitalInput setPoint2 = RobotMap.setPoint2;
	DigitalInput setPoint3 = RobotMap.setPoint3;
	DigitalInput setPoint4 = RobotMap.setPoint4;
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    
    public void runElevator(double power) {
    	victor.set(power);
    }
    
    
    public boolean getPoint0() {
    	return setPoint0.get();
    }
    
    
    public boolean getPoint1() { 
    	return setPoint1.get();
    }

    
    public boolean getPoint2() {
    	return setPoint2.get();
    }

    
    public boolean getPoint3() {
    	return setPoint3.get();
    }


    public boolean getPoint4() {
    	return setPoint4.get();
    }
}

