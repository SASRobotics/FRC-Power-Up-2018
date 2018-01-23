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

