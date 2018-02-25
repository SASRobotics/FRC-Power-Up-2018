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

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	WPI_TalonSRX intakeLeft;
	WPI_TalonSRX intakeRight;
	
	public Intake() {
		super("Intake");
		
		intakeLeft = new WPI_TalonSRX(RobotMap.intakeLeftMotor);
		intakeRight = new WPI_TalonSRX(RobotMap.intakeRightMotor);
	}
	
	//left intake
	public void leftIn(){
		intakeLeft.set(1.00);
	}
	public void leftOut(){
		intakeLeft.set(-1.00);
	}
	public void leftStop(){
		intakeLeft.set(0);	
	}
	
	//right intake
	public void rightIn(){
		intakeRight.set(-1.00);
	}
	public void rightOut(){
		intakeRight.set(1.00);
	}
	public void rightStop(){
		intakeRight.set(0);	
	}	
	
    public void initDefaultCommand() {
    	
    }
}

