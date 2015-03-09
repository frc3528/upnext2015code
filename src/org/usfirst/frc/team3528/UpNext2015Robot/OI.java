package org.usfirst.frc.team3528.UpNext2015Robot;

import org.usfirst.frc.team3528.UpNext2015Robot.commands.*;


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
		public JoystickButton backDrive;
		public JoystickButton backControl;
		public JoystickButton startDrive;
		public JoystickButton start;
		public JoystickButton a;
		public JoystickButton b;
		public JoystickButton x;
		public JoystickButton y;
		public JoystickButton leftTrigger;
		public JoystickButton rightTrigger;
		public JoystickButton rightStick;
		public JoystickButton rightStickTEST;
		public JoystickButton leftStick;
		
		public OI() {
			
			//DriveStick
			driveStick = new Joystick(RobotMap.DRIVESTICK);
			
			
			backDrive = new JoystickButton(driveStick, RobotMap.BACKBUTTON);
			backDrive.whenPressed(new DecreaseSensitivity());
			
			startDrive = new JoystickButton(driveStick, RobotMap.STARTBUTTON);
			startDrive.whenPressed(new IncreaseSensitivity());
			//start.whenPressed(new AutoRecycleAndTote());
			
			//Control Stick
			controlStick = new Joystick(RobotMap.CONTROLSTICK);
			
			
			//Arm
			//reset arm
			a = new JoystickButton (controlStick, RobotMap.A);
			a.whenPressed(new StoreArm());
	
			
			//Picking up totes off the ground
			b = new JoystickButton(controlStick, RobotMap.B);
			b.whenPressed(new PickUpBin());
	
			
			//Scoring on stacks of three
			y = new JoystickButton(controlStick, RobotMap.Y);
			y.whenPressed(new StackOnThree());
	
			
			//Scoring on stacks of four
			x = new JoystickButton(controlStick, RobotMap.X);
			x.whenPressed(new StackBin());
			
			
			start = new JoystickButton(controlStick, 8);
			start.whenPressed(new StepPickUp());
			
			
			//Elevator
			leftTrigger = new JoystickButton(controlStick, RobotMap.LEFTTRIGGER);
			leftTrigger.whenPressed(new LowerElevatorStep());
			
			
			rightTrigger = new JoystickButton(controlStick, RobotMap.RIGHTTRIGGER);
			rightTrigger.whenPressed(new RaiseElevatorStep());

			backControl = new JoystickButton(controlStick, RobotMap.BACKBUTTON);
			backControl.whenPressed(new ResetElevator());
			
			
			//Flipper
			rightStick = new JoystickButton(controlStick, RobotMap.RIGHTSTICKCLICK);
			rightStick.whenPressed(new FlipTote());
			
		
			leftStick = new JoystickButton(controlStick, RobotMap.LEFTSTICKCLICK);
			leftStick.whenPressed(new ManualElevatorReset());
		}
}
