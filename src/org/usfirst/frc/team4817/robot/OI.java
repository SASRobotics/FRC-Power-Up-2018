//      _                                                       _                       _             _
//   __(_)_ _  __ _ __ _ _ __  ___ _ _ ___   __ _ _ __  ___ _ _(_)__ __ _ _ _    ___ __| |_  ___  ___| |
//  (_-< | ' \/ _` / _` | '_ \/ _ \ '_/ -_) / _` | '  \/ -_) '_| / _/ _` | ' \  (_-</ _| ' \/ _ \/ _ \ |
//  /__/_|_||_\__, \__,_| .__/\___/_| \___| \__,_|_|_|_\___|_| |_\__\__,_|_||_| /__/\__|_||_\___/\___/_|
//            |___/     |_|
//
//		________________ _________       ________                                 _____ _________ ____________
//		___  ____/___  __ \__  ____/       ___  __/_____ ______ ________ ___        __  // /__( __ )__<  //__  /
//		__  /_    __  /_/ /_  /            __  /   _  _ \_  __ `/__  __ `__ \       _  // /__  __  |__  / __  /
//		_  __/    _  _, _/ / /___          _  /    /  __// /_/ / _  / / / / /       /__  __// /_/ / _  /  _  /
//		/_/       /_/ |_|  \____/          /_/     \___/ \__,_/  /_/ /_/ /_/          /_/   \____/  /_/   /_/

package org.usfirst.frc.team4817.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4817.robot.commands.ArmCommand;
import org.usfirst.frc.team4817.robot.commands.ClimberCommand;
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
	//climber buttons
	Button climberUp= new JoystickButton(stick1, 5); 
	Button climberDown= new JoystickButton(stick2, 6);
	
	//read joystick
	public double getLeftStick(){
		if(Math.abs(stick1.getY())< 0.05)
			return 0; 
		return -(stick1.getY()); 
	}
	
	public double getRightStick(){
		if(Math.abs(stick2.getY())< 0.05)
			return 0;
		return -(stick2.getY());
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
		//intake out
		out.whenPressed(new IntakeCommand('b', 'o'));
		out.whenReleased(new IntakeCommand('b', 's'));
		//control climber
		climberUp.whenPressed(new ClimberCommand(1));
		climberDown.whenPressed(new ClimberCommand(2));
		//stop climber
		climberUp.whenReleased(new ClimberCommand(0));
		climberDown.whenReleased(new ClimberCommand(0));
	}
}
