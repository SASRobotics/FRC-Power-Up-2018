package org.usfirst.frc.team4817.robot.subsystems;

import org.usfirst.frc.team4817.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Arm extends PIDSubsystem {
	WPI_TalonSRX arm;
	WPI_TalonSRX armSlave;
	
	AnalogInput pot;
    
    public Arm() {
        super("Arm", 1.0, 0.0, 0.0);
        
        arm = new WPI_TalonSRX(RobotMap.armLeftMotor);

		armSlave = new WPI_TalonSRX(RobotMap.armRightMotor);
		armSlave.follow(arm);
		
		pot = new AnalogInput(RobotMap.potInput);
        
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        
        Sendable s = new AnalogPotentiometer(pot);
        s.setName("Arm", "PIDSubsystem Controller");
    }

	public void armUp() {
		arm.set(.1);
	}

	public void armDown() {
		arm.set(-.1);
	}

	public void armStop() {
		arm.set(0);

	}
    
    public void initDefaultCommand() {
    }

    protected double returnPIDInput() {
        return pot.getAverageVoltage();
    }

    protected void usePIDOutput(double output) {
        arm.pidWrite(output);
    }
}
