package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StackBinOnFour extends CommandGroup {
    
    public  StackBinOnFour() {
        // Add Commands here:
        addSequential(new StackBin());
    	addSequential(new WaitForButton());
    }
}
