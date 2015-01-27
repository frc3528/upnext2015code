package org.usfirst.frc.team3528.UpNext2015Robot;

import org.usfirst.frc.team3528.UpNext2015Robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team3528.UpNext2015Robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

	

	public class OI {
	
		public Joystick driveStick;
		public JoystickButton back;
		public JoystickButton start;
		public JoystickButton a;
		
		
		public OI() {
			
			driveStick = new Joystick(RobotMap.DRIVESTICK);
			
			
			a = new JoystickButton(driveStick, RobotMap.A);
			a.whenPressed(new ResetGyro());
			
			back = new JoystickButton(driveStick, RobotMap.BACKBUTTON);
			//back.whenPressed(new DecreaseSensitivity()); 
			back.whenPressed(new AutoDriveForward());
			
			start = new JoystickButton(driveStick, RobotMap.STARTBUTTON);
			//start.whenPressed(new IncreaseSensitivity());
			start.whenPressed(new AutoStrafe());
			
		}
}

