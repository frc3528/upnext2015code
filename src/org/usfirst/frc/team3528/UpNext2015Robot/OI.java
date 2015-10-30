package org.usfirst.frc.team3528.UpNext2015Robot;

import org.usfirst.frc.team3528.UpNext2015Robot.commands.DecreaseSensitivity;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.IncreaseSensitivity;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.MoveElevator;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.PickUpBin;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.StackBinOnFour;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.StoreArm;
import org.usfirst.frc.team3528.UpNext2015Robot.commands.UnlockElevator;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team3528.UpNext2015Robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


	public class OI {
	
		public Joystick testStick;
		public Joystick driveStick;
		public Joystick controlStick;
		
		public JoystickButton startDrive;
		public JoystickButton backDrive;
		
		public JoystickButton backControl;
		public JoystickButton startControl;
		public JoystickButton a;
		public JoystickButton b;
		public JoystickButton x;
		public JoystickButton y;
		public JoystickButton leftTrigger;
		public JoystickButton rightTrigger;
		public JoystickButton rightStick;
		public JoystickButton leftStick;
		
		public JoystickButton rightStickTEST;
		
		
		
		public OI() {
			
			//DriveStick
			driveStick = new Joystick(RobotMap.DRIVESTICK);
			
			
			backDrive = new JoystickButton(driveStick, RobotMap.Y); //X is button three on flightstick
			backDrive.whenPressed(new IncreaseSensitivity());
			
			startDrive = new JoystickButton(driveStick, RobotMap.X); //Y is button four on flightstick
			startDrive.whenPressed(new DecreaseSensitivity());
			
			
			//Control Stick
			controlStick = new Joystick(RobotMap.CONTROLSTICK);
			
			
			//Arm
			//reset arm
			a = new JoystickButton (controlStick, RobotMap.A);
			a.whenPressed(new StoreArm());

			//Picking up totes off the ground
			b = new JoystickButton(controlStick, RobotMap.B);
			b.whenPressed(new PickUpBin());

	
			//Scoring on stacks of four
			x = new JoystickButton(controlStick, RobotMap.X);
			x.whenPressed(new StackBinOnFour());
			

			
			
			//Elevator
			leftTrigger = new JoystickButton(controlStick, RobotMap.LEFTTRIGGER);
			leftTrigger.whenPressed(new MoveElevator("down"));
						
			rightTrigger = new JoystickButton(controlStick, RobotMap.RIGHTTRIGGER);
			rightTrigger.whenPressed(new MoveElevator("up"));
			
			backControl = new JoystickButton(controlStick, RobotMap.BACKBUTTON);
			backControl.whenPressed(new MoveElevator("stack"));
			
			startControl = new JoystickButton(controlStick, RobotMap.STARTBUTTON);
			startControl.whenPressed(new MoveElevator("stack"));

			leftStick = new JoystickButton(controlStick, RobotMap.LEFTSTICKCLICK);
			leftStick.whenPressed(new UnlockElevator());			

			
		}
}
