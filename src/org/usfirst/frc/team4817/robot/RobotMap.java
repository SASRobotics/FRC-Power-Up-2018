package org.usfirst.frc.team4817.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//drive
	public static final int driveLeftFrontMotor = 0;
	public static final int driveLeftRearMotor = 1;
	public static final int driveRightFrontMotor = 2;
	public static final int driveRightRearMotor = 3;
	//arm
	public static final int armLeftMotor = 4;
	public static final int armRightMotor = 5;
	//intake
	public static final int intakeLeftMotor = 6;
	public static final int intakeRightMotor = 7;
	//climber
	public static final int climberMotor = 8;
	//potentiometer
	public static final int potInput = 9;
	//camera
	public static final int imageWidth = 640;
	public static final int imageHeight = 480;
}
