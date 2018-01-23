package org.usfirst.frc.team4817.robot.subsystems;

import org.usfirst.frc.team4817.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	WPI_TalonSRX arm;
	WPI_TalonSRX armSlave;
	
	public Arm() {
		super("Arm");
		
		arm = new WPI_TalonSRX(RobotMap.armLeftMotor);
		
		armSlave = new WPI_TalonSRX(RobotMap.armRightMotor);
        armSlave.follow(arm);
	}
	
	public void armUp(){
		arm.set(.1);
	}
	
	public void armDown(){
		arm.set(-.1);
	}
	
	public void armStop(){
		arm.set(0);
		
	}
	
    public void initDefaultCommand() {
    	
    }
}

