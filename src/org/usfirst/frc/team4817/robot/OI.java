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
import org.usfirst.frc.team4817.robot.commands.ClimberArmCommand;
import org.usfirst.frc.team4817.robot.commands.ClimberCommand;
import org.usfirst.frc.team4817.robot.commands.IntakeCommand;
import org.usfirst.frc.team4817.robot.commands.SliderCommand;

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
	Button armDown= new JoystickButton(stick1, 3);
	//intake buttons
	Button intakeIn = new JoystickButton(stick1, 1);
	Button intakeOut = new JoystickButton(stick2, 1);
		//Button out = new JoystickButton(stick2, 2);
	
	//climber buttons
	Button climberUp= new JoystickButton(stick2, 5); 
	Button climberDown= new JoystickButton(stick2, 6);
	Button climberArmUp = new JoystickButton(stick2, 3);
	Button climberArmDown = new JoystickButton(stick2, 4);
	
	//slider buttons
	Button sliderOut = new JoystickButton(stick1, 6);
	Button sliderIn = new JoystickButton(stick1, 5);
	
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

		intakeIn.whenPressed(new IntakeCommand('i'));
		intakeIn.whenReleased(new IntakeCommand('s'));

		intakeOut.whenPressed(new IntakeCommand('o'));
		intakeOut.whenReleased(new IntakeCommand('s'));
		/*//left intake
		leftIntake.whenPressed(new IntakeCommand('i'));
		leftIntake.whenReleased(new IntakeCommand('l', 's'));
		//right intake
		rightIntake.whenPressed(new IntakeCommand('r', 'i'));
		rightIntake.whenReleased(new IntakeCommand('r', 's'));
		//intake out
		out.whenPressed(new IntakeCommand('b', 'o'));
		out.whenReleased(new IntakeCommand('b', 's'));*/

		sliderOut.whenPressed(new SliderCommand(1));
		sliderOut.whenReleased(new SliderCommand(0));
		
		sliderIn.whenPressed(new SliderCommand(2));
		sliderIn.whenReleased(new SliderCommand(0));
		//control climber
		climberUp.whenPressed(new ClimberCommand(1));
		climberDown.whenPressed(new ClimberCommand(2));
		//stop climber
		climberUp.whenReleased(new ClimberCommand(0));
		climberDown.whenReleased(new ClimberCommand(0));
		
		//climber arm
		climberArmUp.whenPressed(new ClimberArmCommand(1));
		climberArmDown.whenPressed(new ClimberArmCommand(2));
		//stop climber arm
		climberArmUp.whenReleased(new ClimberArmCommand(0));
		climberArmDown.whenReleased(new ClimberArmCommand(0));
	}
}
