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
		public Joystick controlStick;
		public JoystickButton back;
		public JoystickButton start;
		public JoystickButton a;
		public JoystickButton x;
		public JoystickButton y;
		public JoystickButton leftTrigger;
		public JoystickButton rightTrigger;
		
		
		public OI() {
			
			driveStick = new Joystick(RobotMap.DRIVESTICK);
			
			a = new JoystickButton(driveStick, RobotMap.A);
			a.whenPressed(new ResetGyro());

			x = new JoystickButton(driveStick, RobotMap.X);
			
			
			y = new JoystickButton(driveStick, RobotMap.Y);
			
			leftTrigger = new JoystickButton(driveStick, RobotMap.LEFTTRIGGER);
			
			rightTrigger = new JoystickButton(driveStick, RobotMap.RIGHTTRIGGER);
			rightTrigger.whenPressed(new raiseElevatorStep());

			
			back = new JoystickButton(driveStick, RobotMap.BACKBUTTON);
			back.whenPressed(new DecreaseSensitivity()); 
			
			start = new JoystickButton(driveStick, RobotMap.STARTBUTTON);
			start.whenPressed(new IncreaseSensitivity());
			
			
			controlStick = new Joystick(RobotMap.CONTROLSTICK);
			
		}
}

