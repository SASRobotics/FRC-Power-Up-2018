package org.usfirst.frc.team4817.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4817.robot.Robot;
/**
 *
 */
public class JoystickDrive extends Command {

	public JoystickDrive() {
        requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.tankDrive(Robot.oi.getLeftStick(), Robot.oi.getRightStick());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
