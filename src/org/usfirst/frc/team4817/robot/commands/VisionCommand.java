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

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4817.robot.commands.GripPipeline;

import org.usfirst.frc.team4817.robot.Robot;
import org.usfirst.frc.team4817.robot.RobotMap;

import java.util.ArrayList;
import java.util.Arrays;

import org.opencv.core.*;
import org.opencv.core.Core.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;


/**
 *
 */
public class VisionCommand extends Command {
	
  //vision
	private VisionThread visionThread;
	private boolean left;
	private final Object imgLock = new Object();

	private static final int IMG_WIDTH = 640;
	private static final int IMG_HEIGHT = 480;
	private static final double SPEED = 0.5;
  
  public VisionCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    if (visionThread == null) {
	    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
	        if (!pipeline.filterContoursOutput().isEmpty()) {
	            ArrayList<MatOfPoint> output = pipeline.filterContoursOutput();
	            
	            
	    		double maxArea = 0;
	    		Rect rect = null;
	    		for (MatOfPoint each : output) {
	    			Rect r = Imgproc.boundingRect(each);
	    			double a = r.size().area();
	    			if (a > maxArea) {
	    				maxArea = a;
	    				rect = r;
	    			}
	    		}
	    		
	    		int rectCenter = rect.x + rect.width/2;
	    		
	
	    		System.out.println("left?: " + (IMG_WIDTH/2 - rectCenter));
	    		
	            synchronized (imgLock) {
	            	left = (IMG_WIDTH/2 - rectCenter) > 0;
	            }
	        }
	    });
    }
    visionThread.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {

		boolean left;
		synchronized (imgLock) {
			left = this.left;

		}
		
		
		System.out.println("left: " + left);
		
		if (left) {
			Robot.drive.tankDrive(SPEED, 0);
		} else {
			Robot.drive.tankDrive(0, SPEED);
		}

//		Robot.drive.driveStraight(SPEED);
		
		
    
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
