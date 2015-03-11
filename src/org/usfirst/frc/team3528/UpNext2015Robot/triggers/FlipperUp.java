package org.usfirst.frc.team3528.UpNext2015Robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class FlipperUp extends Trigger {
    
	private Joystick joy;
	
	public FlipperUp(Joystick joy) {
		this.joy = joy;
	}
	
    public boolean get() {
    	if(joy.getRawAxis(3) >= .8) {
    		return true;
    	} else {
    	return false;
    	}
    }
}
