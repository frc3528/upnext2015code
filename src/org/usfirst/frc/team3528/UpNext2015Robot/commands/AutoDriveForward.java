package org.usfirst.frc.team3528.UpNext2015Robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveForward extends CommandGroup {
    
    public  AutoDriveForward() {
        
        addSequential(new DriveByFeet(1440, 5.0, 0.5));

      
    }
}