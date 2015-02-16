package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ResetArm extends CommandGroup {
    
    public  ResetArm() {
        addSequential(new StoreArm());
        addSequential(new ZeroArmEncoders());

    }
}
