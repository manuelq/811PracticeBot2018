package org.usfirst.frc.team811.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


//import org.opencv.core.Core;
import org.usfirst.frc.team811.robot.*;
import org.usfirst.frc.team811.robot.commands.*;
import org.usfirst.frc.team811.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot 
{
	public static Drive drive;
	public static Ultrasonic ultra;
	
	public static OI oi;
	public static RobotMap robotMap;
	
	//Command autonomousCommand;
	//SendableChooser autoChooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() 
	{

		robotMap = new RobotMap();
		robotMap.init();

		drive = new Drive();


		oi = new OI();
		// System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		ultra.setAutomaticMode(true);

		
	}

	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit() 
	{
		// schedule the autonomous command (example)
		/*
		autonomousCommand = ;
		autonomousCommand.start();
		*/
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();

	}

	public void teleopInit() 
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		//if (autonomousCommand != null)
		//	autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() 
	{

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();

		SmartDashboard.putNumber("gyro value", RobotMap.ahrs.getYaw());
		SmartDashboard.putNumber("drive encoder distance",
				RobotMap.driveEncoder.getDistance());
		SmartDashboard.putNumber("drive encoder raw",
				RobotMap.driveEncoder.getRaw());
		SmartDashboard.putNumber("drive encoder get",
				RobotMap.driveEncoder.get());
		
		SmartDashboard.putNumber("ultrasthingggy", 
				RobotMap.ultra.getRangeInches());
	
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() 
	{
		LiveWindow.run();
	}
}