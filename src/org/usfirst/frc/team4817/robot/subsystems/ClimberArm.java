package org.usfirst.frc.team4817.robot.subsystems;

import org.usfirst.frc.team4817.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClimberArm extends Subsystem {
	WPI_TalonSRX climberArm;  
	
	public ClimberArm() {
		super ("Climber Arm"); 
		climberArm = new WPI_TalonSRX(RobotMap.climberArmMotor);
		
	}
	
	public void armUp(){
		climberArm.set(1.00);
	}
	
	public void armDown(){
		climberArm.set(-1.00);
	}
	
	public void armStop(){
		climberArm.set(0);
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

