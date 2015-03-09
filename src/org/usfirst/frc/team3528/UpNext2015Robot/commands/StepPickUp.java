package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StepPickUp extends CommandGroup {
    
    public  StepPickUp() {
    	setInterruptible(false);
    	addSequential(new PickUpFromStep());
    	addSequential(new WaitForButton());
    	addSequential(new PullBackFromStep());
    }
}
