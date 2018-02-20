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

