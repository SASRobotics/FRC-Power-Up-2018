//      _                                                       _                       _             _
//   __(_)_ _  __ _ __ _ _ __  ___ _ _ ___   __ _ _ __  ___ _ _(_)__ __ _ _ _    ___ __| |_  ___  ___| |
//  (_-< | ' \/ _` / _` | '_ \/ _ \ '_/ -_) / _` | '  \/ -_) '_| / _/ _` | ' \  (_-</ _| ' \/ _ \/ _ \ |
//  /__/_|_||_\__, \__,_| .__/\___/_| \___| \__,_|_|_|_\___|_| |_\__\__,_|_||_| /__/\__|_||_\___/\___/_|
//            |___/     |_|
//
//		________________ _________       ________                                 _____ _________ ____________
//		___  ____/___  __ \__  ____/       ___  __/_____ ______ ________ ___        __  // /__( __ )__<  //__  /
//		__  /_    __  /_/ /_  /            __  /   _  _ \_  __ `/__  __ `__ \       _  // /__  __  |__  / __  /
//		_  __/    _  _, _/ / /___          _  /    /  __// /_/ / _  / / / / /       /__  __// /_/ / _  /  _  /
//		/_/       /_/ |_|  \____/          /_/     \___/ \__,_/  /_/ /_/ /_/          /_/   \____/  /_/   /_/

package org.usfirst.frc.team4817.robot.commands;

import org.usfirst.frc.team4817.robot.Robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class PlaceOnSwitch extends Command {

    public char direction;
    public char position;
    Accelerometer accel;

    public PlaceOnSwitch(char dir, char pos) {
        direction = dir;
        position = pos;
    }

    // Called just before this Command runs the first time
    protected void initialize() {

        accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
        System.out.println(accel.getX());
        System.out.println(accel.getY());
        System.out.println(accel.getZ());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(position == 'M') {
            if (direction == 'L') {
                turnLeft();
                driveStraight(1500);
                turnRight();
                raiseArm(400);
               do {
                   driveStraight(10);
                   System.out.println(accel.getY());
               } while (accel.getY() > 0.9);
                releaseCube();
                turnLeft();
                driveStraight(1000);
                turnRight();
                driveStraight(5000);
            } else if (direction == 'R') {
                turnRight();
                driveStraight(1500);
                turnLeft();
                raiseArm(400);
                do {
                    driveStraight(10);
                    System.out.println(accel.getY());
                } while (accel.getY() < 0.9);
                releaseCube();
                turnRight();
                driveStraight(1000);
                turnLeft();
                driveStraight(5000);
            }
        }
        if(position == 'L') {
            if(direction == 'L') {

            } else if(direction == 'R') {

            }
        }
        if(position == 'R') {
            if(direction == 'L') {

            } else if (direction == 'R') {

            }
        }

    }
    public void raiseArm(long duration) {
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < duration) {
            Robot.arm.armUp();
        }
    }
    public void releaseCube() {
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < 500) {
            Robot.intake.leftOut();
            Robot.intake.rightOut();
        }
    }

    public void driveStraight(long duration) {
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < duration) {
            Robot.drive.tankDrive(0.8, 0.8);
        }
    }



    public void turnRight() {
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < 385) {
            Robot.drive.tankDrive(+.64, -.64);
        }
    }

    public void turnLeft() {
        long startTime = System.currentTimeMillis();
        while((System.currentTimeMillis() - startTime) < 385) {
            Robot.drive.tankDrive(-.64, .64);
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
