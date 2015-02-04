package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.DriveFromJoysticks;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	private RobotDrive robotDrive;
	private double speedX, speedY, speedZ;
	private Encoder motorEncoderFront;
	private Encoder motorEncoderRear;
	private double xDistanceTraveled;
	private double yDistanceTraveled;
	
	public DriveSystem() {
		robotDrive = new RobotDrive(RobotMap.frontLeftMotor, RobotMap.rearLeftMotor,
				RobotMap.frontRightMotor, RobotMap.rearRightMotor);
		speedX = 0.0;
		speedY = 0.0;
		speedZ = 0.0;
		
		motorEncoderFront = new Encoder(RobotMap.motorEncoderPort1, RobotMap.motorEncoderPort2);
		motorEncoderRear = new Encoder(RobotMap.motorEncoderPort3, RobotMap.motorEncoderPort4);
		xDistanceTraveled = 0.0;
		yDistanceTraveled = 0.0;
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
	
	public int getFrontPosition() {
		return motorEncoderFront.getRaw();
	}
	
	public int getRearPosition() {
		return motorEncoderRear.getRaw();
	}
    
	public void setXDistanceTraveled(double xDistanceTraveled) {
		this.xDistanceTraveled = xDistanceTraveled;
	}
	
	public double getXDistanceTraveled() {
		return xDistanceTraveled;
	}
	
	public void setYDistanceTraveled(double yDistanceTraveled) {
		this.yDistanceTraveled = yDistanceTraveled;
	}
	
	public double getYDistanceTraveled() {
		return yDistanceTraveled;
	}
	
}

