package org.usfirst.frc.team3528.UpNext2015Robot;

import org.usfirst.frc.team3528.UpNext2015Robot.commands.DecreaseSensitivity;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.IncreaseSensitivity;

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
		
		public OI() {
			
			driveStick = new Joystick(RobotMap.DRIVESTICK);
			
			
			back = new JoystickButton(driveStick, RobotMap.BACKBUTTON);
			//back.whenPressed(new DecreaseSensitivity()); 
			
			start = new JoystickButton(driveStick, RobotMap.STARTBUTTON);
			//start.whenPressed(new IncreaseSensitivity());
			
		}
}

