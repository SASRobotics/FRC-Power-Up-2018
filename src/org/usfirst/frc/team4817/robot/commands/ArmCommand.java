package org.usfirst.frc.team4817.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4817.robot.Robot;

/**
 *
 */
public class ArmCommand extends Command {

	public int direction; 
    public ArmCommand(int d) {
    	requires(Robot.arm); 
    	direction = d; 
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (direction == 1){
    		Robot.arm.armUp(); 

    	}
    	else if (direction == 2){
    		Robot.arm.armDown(); 
    	}
    	else{
    		Robot.arm.armStop();
    		
    	}
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
