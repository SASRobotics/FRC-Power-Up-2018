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
		if(pot.get() <= 361)
			arm.set(1.0);
		//System.out.println(pot.get());
	}

	public void armDown() {
		//main is >= 359
		//backup is <= 342
		if(pot.get() >= 359)
			arm.set(-1.0);
		//System.out.println(pot.get());
	}

	public void armStop() {
		arm.set(0);

	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}