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

package org.usfirst.frc.team4817.robot.subsystems;

import org.usfirst.frc.team4817.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

/**
 *
 */
public class Arm extends Subsystem {
	WPI_TalonSRX arm;
	WPI_TalonSRX armSlave;
	
	Potentiometer pot;
	
	AnalogInput ai = new AnalogInput(0);
    
    public Arm() {
        super("Arm");
        
        arm = new WPI_TalonSRX(RobotMap.armMotor);

		//armSlave = new WPI_TalonSRX(RobotMap.armRightMotor);
		//armSlave.follow(arm);
		
        pot = new AnalogPotentiometer(ai, 360, 0);
    }

	public void armUp() {
		//main is <= 361
		//backup is >= .36
		//if(pot.get() >= .50)
			arm.set(.8);
		System.out.println(pot.get());
	}

	public void armDown() {
		//main is >= 359
		//backup is <= 342
		if(pot.get() <= 0.7)
			arm.set(-.8);
		System.out.println(pot.get());
	}

	public void armStop() {
		arm.set(0);

	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}