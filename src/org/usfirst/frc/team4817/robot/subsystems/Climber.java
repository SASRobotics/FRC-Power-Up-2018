package org.usfirst.frc.team4817.robot.subsystems;

import org.usfirst.frc.team4817.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	WPI_TalonSRX climber;  
	
	public Climber() {
		super ("Climber"); 
		climber = new WPI_TalonSRX(RobotMap.climberMotor);
		
	}
	
	public void climbUp(){
		climber.set(1.00);
	}
	
	public void climbDown(){
		climber.set(-1.00);
	}
	
	public void climbStop(){
		climber.set(0);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

