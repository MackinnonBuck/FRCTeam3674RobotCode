package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.DriveFromJoysticks;
import org.usfirst.frc.team3674.robot.triggers.LeftTrigger;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	private RobotDrive robotDrive;
	private double speedX, speedY, speedZ;
	
	public DriveSystem() {
		robotDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.rearLeftMotor,
				RobotMap.frontRightMotor, RobotMap.rearRightMotor);
		speedX = 0.0;
		speedY = 0.0;
		speedZ = 0.0;
	}

    public void initDefaultCommand() {
        setDefaultCommand(new DriveFromJoysticks());
    }
    
    public void drive() {
    	robotDrive.mecanumDrive_Cartesian(speedX, speedY, speedZ, 0);
    }
	
	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double speedX) {
		this.speedX = speedX;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double speedY) {
		this.speedY = speedY;
	}

	public double getSpeedZ() {
		return speedZ;
	}

	public void setSpeedZ(double speedZ) {
		this.speedZ = speedZ;
	}
    
}

