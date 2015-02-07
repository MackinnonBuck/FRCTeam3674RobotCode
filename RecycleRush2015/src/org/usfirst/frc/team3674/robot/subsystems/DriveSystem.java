package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.DriveFromJoysticks;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSystem extends Subsystem {
	
	private Talon frontLeftTalon;
	private Talon rearLeftTalon;
	private Talon frontRightTalon;
	private Talon rearRightTalon;
	private RobotDrive robotDrive;
	private double speedX, speedY, speedZ;
	private Encoder motorEncoderFront;
	private Encoder motorEncoderRear;
	
	public DriveSystem() {
		frontLeftTalon = new Talon(RobotMap.frontLeftMotor);
		rearLeftTalon = new Talon(RobotMap.rearLeftMotor);
		frontRightTalon = new Talon(RobotMap.frontRightMotor);
		rearRightTalon = new Talon(RobotMap.rearRightMotor);
		robotDrive = new RobotDrive(frontLeftTalon, rearLeftTalon,
				frontRightTalon, rearRightTalon);
		robotDrive.setInvertedMotor(MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(MotorType.kRearRight, true);
		
		speedX = 0.0;
		speedY = 0.0;
		speedZ = 0.0;
		
		motorEncoderFront = new Encoder(RobotMap.motorEncoderPort1, RobotMap.motorEncoderPort2);
		motorEncoderRear = new Encoder(RobotMap.motorEncoderPort3, RobotMap.motorEncoderPort4);
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

	public double getFrontLeftTalonPower() {
		return frontLeftTalon.get();
	}

	public void setFrontLeftTalonPower(double power) {
		frontLeftTalon.set(power);
	}

	public double getRearLeftTalonPower() {
		return rearLeftTalon.get();
	}

	public void setRearLeftTalonPower(double power) {
		rearLeftTalon.set(power);
	}

	public double getFrontRightTalonPower() {
		return frontRightTalon.get();
	}

	public void setFrontRightTalonPower(double power) {
		frontRightTalon.set(power);
	}

	public double getRearRightTalonPower() {
		return rearRightTalon.get();
	}

	public void setRearRightTalonPower(double power) {
		rearRightTalon.set(power);
	}
	
}

