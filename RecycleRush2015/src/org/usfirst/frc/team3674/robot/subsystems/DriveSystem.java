package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.DriveFromJoysticks;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	public RobotDrive robotDrive;
	
	public DriveSystem() {
		robotDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.rearLeftMotor,
				RobotMap.frontRightMotor, RobotMap.rearRightMotor);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new DriveFromJoysticks());
    }
}

