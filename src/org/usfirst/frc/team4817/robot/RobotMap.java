package org.usfirst.frc.team4817.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	//drive
	public static final int driveLeftFrontMotor = 2;
	public static final int driveLeftRearMotor = 3;
	public static final int driveRightFrontMotor = 6;
	public static final int driveRightRearMotor = 4;
	//arm
	public static final int armMotor = 7;
	//intake
	public static final int intakeLeftMotor = 6;
	public static final int intakeRightMotor = 7;
	//climber
	public static final int climberMotor = 8;
}
