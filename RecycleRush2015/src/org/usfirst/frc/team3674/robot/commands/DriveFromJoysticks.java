package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveFromJoysticks extends Command {
	
	private double xPower;
	private double yPower;
	private double zPower;
	private double leftStickX;
	private double leftStickY;
	private double rightStickX;
	private double accelRate;
	private double deadZone;
	
    public DriveFromJoysticks() {
        requires(Robot.driveSystem);
        xPower = 0.0;
        yPower = 0.0;
        zPower = 0.0;
        leftStickX = 0.0;
        leftStickY = 0.0;
        rightStickX = 0.0;
        accelRate = 0.015;
        deadZone = 0.1;
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	leftStickX = Math.abs(OI.stick1.getRawAxis(0)) > deadZone ? OI.stick1.getRawAxis(0) : 0.0;
    	leftStickY = Math.abs(OI.stick1.getRawAxis(1)) > deadZone ? OI.stick1.getRawAxis(1) : 0.0;
    	rightStickX = Math.abs(OI.stick1.getRawAxis(4)) > deadZone ? OI.stick1.getRawAxis(4) : 0.0;
    	
    	if (OI.stick1.getRawAxis(2) >= deadZone) {
    		xPower = increaseSpeed(xPower, leftStickX, accelRate);
    		yPower = increaseSpeed(yPower, leftStickY, accelRate);
    		zPower = increaseSpeed(zPower, rightStickX, accelRate);
    	} else {
    		xPower = leftStickX;
    		yPower = leftStickY;
    		zPower = rightStickX;
    	}
    	
    	if (OI.stick1.getRawAxis(3) >= deadZone) {
	    	Robot.driveSystem.setSpeedX(Math.max(Math.min(xPower, 0.25), -0.25));
	    	Robot.driveSystem.setSpeedY(Math.max(Math.min(yPower, 0.25), -0.25));
	    	Robot.driveSystem.setSpeedZ(Math.max(Math.min(zPower, 0.25), -0.25));
    	} else {
    		Robot.driveSystem.setSpeedX(xPower);
	    	Robot.driveSystem.setSpeedY(yPower);
	    	Robot.driveSystem.setSpeedZ(zPower);
    	}
    	Robot.driveSystem.drive();
    	
    	SmartDashboard.putNumber("X Power:", xPower);
    	SmartDashboard.putNumber("Y Power:", yPower);
    	SmartDashboard.putNumber("Z Power:", zPower);
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
