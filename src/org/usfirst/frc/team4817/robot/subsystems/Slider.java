package org.usfirst.frc.team4817.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4817.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class Slider extends Subsystem {

   WPI_TalonSRX slider;
   
   public Slider() {
	   super("Slider");
	   
	   slider = new WPI_TalonSRX(RobotMap.sliderMotor);
   }
   
   public void sliderOut() {
	   slider.set(1.0);
   }
   
   public void sliderIn() {
	   slider.set(-1.0);
   }
   
   public void sliderStop() {
	   slider.set(0.0);
   }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

