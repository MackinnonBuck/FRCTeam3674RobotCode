package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveFromJoysticks extends Command {
	
	private double leftStickX;
	private double leftStickY;
	private double rightStickX;
	private double rawLeftStickX;
	private double rawLeftStickY;
	private double rawRightStickX;
	private double accelRate;
	private double deadZone;
	
    public DriveFromJoysticks() {
        requires(Robot.driveSystem);
        leftStickX = 0.0;
        leftStickY = 0.0;
        rightStickX = 0.0;
        rawLeftStickX = 0.0;
        rawLeftStickY = 0.0;
        rawRightStickX = 0.0;
        accelRate = 0.05;
        deadZone = 0.1;
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	rawLeftStickX = Math.abs(OI.stick1.getRawAxis(0)) > deadZone ? OI.stick1.getRawAxis(0) : 0.0;
    	rawLeftStickY = Math.abs(OI.stick1.getRawAxis(1)) > deadZone ? OI.stick1.getRawAxis(1) : 0.0;
    	rawRightStickX = Math.abs(OI.stick1.getRawAxis(4)) > deadZone ? OI.stick1.getRawAxis(4) : 0.0;
    	
    	if (OI.stick1.getRawButton(5)) {
    		leftStickX = increaseSpeed(leftStickX, rawLeftStickX, accelRate);
    		leftStickY = increaseSpeed(leftStickY, rawLeftStickY, accelRate);
    		rightStickX = increaseSpeed(rightStickX, rawRightStickX, accelRate);
    	} else {
    		leftStickX = rawLeftStickX;
    		leftStickY = rawLeftStickY;
    		rightStickX = rawRightStickX;
    	}
    	
    	if (OI.stick1.getRawButton(6)) {
	    	Robot.driveSystem.setSpeedX(Math.max(Math.min(leftStickX, 0.25), -0.25));
	    	Robot.driveSystem.setSpeedY(Math.max(Math.min(leftStickY, 0.25), -0.25));
	    	Robot.driveSystem.setSpeedZ(Math.max(Math.min(rightStickX, 0.25), -0.25));
    	} else {
    		Robot.driveSystem.setSpeedX(leftStickX);
	    	Robot.driveSystem.setSpeedY(leftStickY);
	    	Robot.driveSystem.setSpeedZ(rightStickX);
    	}
    	Robot.driveSystem.drive();
    	
    	SmartDashboard.putNumber("Left Joystick X:", leftStickX);
    	SmartDashboard.putNumber("Left Joystick Y:", leftStickY);
    	SmartDashboard.putNumber("Right Joystick X:", rightStickX);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
    
    private double increaseSpeed(double currentSpeed, double targetSpeed, double accelRate) {
    	if (currentSpeed < targetSpeed) {
    		currentSpeed += accelRate;
    		if (currentSpeed > targetSpeed) currentSpeed = targetSpeed;
    	} else if (currentSpeed > targetSpeed) {
    		currentSpeed -= accelRate;
    		if (currentSpeed < targetSpeed) currentSpeed = targetSpeed;
    	}
    	
    	return currentSpeed;
    }
}
