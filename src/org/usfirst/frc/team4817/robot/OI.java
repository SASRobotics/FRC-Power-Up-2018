package org.usfirst.frc.team4817.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4817.robot.commands.ArmCommand;
import org.usfirst.frc.team4817.robot.commands.ExampleCommand;
import org.usfirst.frc.team4817.robot.commands.IntakeCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//joysticks
	Joystick stick1= new Joystick(0);
	Joystick stick2= new Joystick (1);
	//arm buttons
	Button armUp= new JoystickButton(stick1, 4); 
	Button armDown= new JoystickButton(stick2, 3);
	//intake buttons
	Button leftIntake = new JoystickButton(stick1, 1);
	Button rightIntake = new JoystickButton(stick2, 1);
	Button out = new JoystickButton(stick2, 2);
	
	//read joystick
	public double getLeftStick(){
		if(Math.abs(stick1.getY())< 0.05)
			return 0; 
		return stick1.getY(); 
	}
	
	public double getRightStick(){
		if(Math.abs(stick2.getY())< 0.05)
			return 0;
		return stick2.getY();
	}
	
	
	public OI() {
		//control arm
		armUp.whenPressed(new ArmCommand(1));
		armDown.whenPressed(new ArmCommand(2));
		//stop arm
		armUp.whenReleased(new ArmCommand(0));
		armDown.whenReleased(new ArmCommand(0));
		//left intake
		leftIntake.whenPressed(new IntakeCommand('l', 'i'));
		leftIntake.whenReleased(new IntakeCommand('l', 's'));
		//right intake
		rightIntake.whenPressed(new IntakeCommand('r', 'i'));
		rightIntake.whenReleased(new IntakeCommand('r', 's'));
		//out
		out.whenPressed(new IntakeCommand('b', 'o'));
		out.whenReleased(new IntakeCommand('b', 's'));
		
	}
}
