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

		package org.usfirst.frc.team4817.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4817.robot.commands.PlaceOnSwitch;
import org.usfirst.frc.team4817.robot.subsystems.Arm;
import org.usfirst.frc.team4817.robot.subsystems.Drive;
import org.usfirst.frc.team4817.robot.subsystems.Intake;
import org.usfirst.frc.team4817.robot.subsystems.Climber;
import org.usfirst.frc.team4817.robot.subsystems.ClimberArm;
import org.usfirst.frc.team4817.robot.subsystems.Slider;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import org.opencv.core.*;
import org.opencv.core.Core.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.vision.VisionRunner;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static final RobotMap robotMap = new RobotMap();
	
	//drive
	public static final Drive drive = new Drive();
	//arm
	public static final Arm arm = new Arm();
	//intake
	public static final Intake intake = new Intake();
	//climber
	public static final Climber climber = new Climber();
	//slider
	public static final Slider slider = new Slider();
	//climber arm
	public static final ClimberArm climberArm = new ClimberArm();


	Command autonomousCommand;

	//vision
	//private VisionThread visionThread;
	//private boolean left;
	//private final Object imgLock = new Object();

	//private static final int IMG_WIDTH = 640;
	//private static final int IMG_HEIGHT = 480;
	//private static final double SPEED = 0.5;
  

	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {

		oi = new OI();
		//chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		//SmartDashboard.putData("Auto mode", chooser);

		/*UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
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
		visionThread.start();*/
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		//autonomousCommand = chooser.getSelected();
		// autonomousCommand = new VisionCommand();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.length() > 0)
		{
			if(gameData.charAt(0) == 'L')
			{
				autonomousCommand = new PlaceOnSwitch('L', 'M');
				autonomousCommand.start();

			} else {
				autonomousCommand = new PlaceOnSwitch('R', 'M');
				autonomousCommand.start();
			}
		}

	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		 Scheduler.getInstance().run();
		/*boolean left;
		synchronized (imgLock) {
			left = this.left;

		}


		System.out.println("left: " + left);

		if (left) {
			drive.tankDrive(SPEED, 0);
		} else {
			drive.tankDrive(0, SPEED);
		}*/
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
