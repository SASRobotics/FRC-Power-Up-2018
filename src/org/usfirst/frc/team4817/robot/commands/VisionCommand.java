package org.usfirst.frc.team4817.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team4817.robot.commands.GripPipeline;

import org.usfirst.frc.team4817.robot.Robot;
import org.usfirst.frc.team4817.robot.RobotMap;

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
	private ArrayList<Line> visionOutput;
	private final Object imgLock = new Object();

  private static final int IMG_WIDTH = 640;
	private static final int IMG_HEIGHT = 480;
  
  public VisionCommand() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    
    visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
        if (!pipeline.filterLinesOutput().isEmpty()) {
            ArrayList<Line> output = pipeline.filterLinesOutput();
            synchronized (imgLock) {
                visionOutput = output;
            }
        }
    });
    visionThread.start();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
    ArrayList<Line> output;
    synchronized (imgLock) {
        output = visionOutput;
    }
    System.out.println(Arrays.toString(output.toArray()));
    
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
