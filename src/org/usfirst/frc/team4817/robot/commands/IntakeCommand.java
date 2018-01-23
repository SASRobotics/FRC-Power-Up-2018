package org.usfirst.frc.team4817.robot.commands;

import org.usfirst.frc.team4817.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeCommand extends Command {

	public char side;
	public char direction;
	
    public IntakeCommand(char s, char d) {
    	requires(Robot.intake);
    	side = s;
    	direction = d; 
    }
    
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (side == 'l') {
    		if (direction == 'i'){
        		Robot.intake.leftIn(); 
        	}
        	else if (direction == 's'){
        		Robot.intake.leftStop();
        	}
    	} else if (side == 'r') {
    		if (direction == 'i'){
        		Robot.intake.rightIn(); 
        	}
        	else if (direction == 's'){
        		Robot.intake.rightStop();
        	}
    	} else if (side == 'b'){
    		if (direction == 'o') {
    			Robot.intake.leftOut();
        		Robot.intake.rightOut(); 
    		} else if (direction == 's') {
    			Robot.intake.leftStop();
        		Robot.intake.rightStop(); 
    		}
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
