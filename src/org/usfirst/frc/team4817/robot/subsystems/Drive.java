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
import org.usfirst.frc.team4817.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {
	DifferentialDrive drive;
	
	//left side mc's
	WPI_TalonSRX leftFront = new WPI_TalonSRX(RobotMap.driveLeftFrontMotor);
	WPI_TalonSRX leftRear = new WPI_TalonSRX(RobotMap.driveLeftRearMotor);
	
	//right side mc's
	WPI_TalonSRX rightFront = new WPI_TalonSRX(RobotMap.driveRightFrontMotor);
	WPI_TalonSRX rightRear = new WPI_TalonSRX(RobotMap.driveRightRearMotor);

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Drive() {
		super("Drive");
		
		//drive
		drive = new DifferentialDrive(leftFront, rightFront);
		drive.setSafetyEnabled(false);
		//pair motors
    	leftRear.follow(leftFront);
    	rightRear.follow(rightFront);
	}
	
	public void tankDrive(double left, double right){
		drive.tankDrive((left),(right));
	}
	
	public void driveStraight(double speed){
		drive.tankDrive(speed,speed);
		
	}

    public void initDefaultCommand() {
    	//joystick pair
    	setDefaultCommand(new JoystickDrive());
    }
}

