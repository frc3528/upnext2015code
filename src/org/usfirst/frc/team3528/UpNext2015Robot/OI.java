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
		public JoystickButton b;
		public JoystickButton x;
		public JoystickButton y;
		public JoystickButton leftTrigger;
		public JoystickButton rightTrigger;
		
		
		public OI() {
			
			driveStick = new Joystick(RobotMap.DRIVESTICK);
			
			//Need to change this to control stick when resetting the gyro is automatic.
			//For picking up recycle bins off floor.
			a = new JoystickButton(driveStick, RobotMap.A);
			a.whenPressed(new ResetGyro());
			
			//For lifting bins up to score on tote stack.
			b = new JoystickButton(controlStick, RobotMap.B);
			
			//Picking up totes off the step.
			x = new JoystickButton(controlStick, RobotMap.X);
			
			
			y = new JoystickButton(controlStick, RobotMap.Y);
			
			leftTrigger = new JoystickButton(controlStick, RobotMap.LEFTTRIGGER);
			leftTrigger.whenPressed(new LowerElevatorStep());
			
			rightTrigger = new JoystickButton(controlStick, RobotMap.RIGHTTRIGGER);
			//rightTrigger.whenPressed(new RaiseElevatorStep());
			rightTrigger.whenPressed(new RaiseElevatorStep());

			
			back = new JoystickButton(driveStick, RobotMap.BACKBUTTON);
			back.whenPressed(new DecreaseSensitivity()); 
			
			start = new JoystickButton(driveStick, RobotMap.STARTBUTTON);
			start.whenPressed(new IncreaseSensitivity());
			
			
			controlStick = new Joystick(RobotMap.CONTROLSTICK);
			
		}
}
