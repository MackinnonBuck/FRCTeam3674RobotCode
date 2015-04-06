package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFromJoysticks extends Command {
	
	private double xSpeed;
	private double ySpeed;
	private double zSpeed;
	private double speedLimit;
	private double targetSpeedX;
	private double targetSpeedY;
	private double targetSpeedZ;
	private double accelRate;
	private double deadZone;
	
    public DriveFromJoysticks() {
        requires(Robot.driveSystem);
        xSpeed = 0.0;
        ySpeed = 0.0;
        zSpeed = 0.0;
        targetSpeedX = 0.0;
        targetSpeedY = 0.0;
        targetSpeedZ = 0.0;
        speedLimit = 1.0;
        accelRate = 0.025;
        deadZone = 0.1;
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	if (OI.stick1.getPOV() != -1 || OI.stick1.getRawAxis(3) >= deadZone) {
    		speedLimit = 0.25;
    	} else {
    		speedLimit = 1.0;
    	}
    
    	if (OI.stick1.getPOV() != -1) {
    		switch (OI.stick1.getPOV()) {
    		case 0:
    			targetSpeedX = 0.0;
    			targetSpeedY = -speedLimit;
    			break;
    		case 45:
    			targetSpeedX = speedLimit * 2.0;
    			targetSpeedY = -speedLimit;
    			break;
    		case 90:
    			targetSpeedX = speedLimit * 2.0;
    			targetSpeedY = 0.0;
    			break;
    		case 135:
    			targetSpeedX = speedLimit * 2.0;
    			targetSpeedY = speedLimit;
    			break;
    		case 180:
    			targetSpeedX = 0.0;
    			targetSpeedY = speedLimit;
    			break;
    		case 225:
    			targetSpeedX = -speedLimit * 2.0;
    			targetSpeedY = speedLimit;
    			break;
    		case 270:
    			targetSpeedX = -speedLimit * 2.0;
    			targetSpeedY = 0.0;
    			break;
    		case 315:
    			targetSpeedX = -speedLimit * 2.0;
    			targetSpeedY = -speedLimit;
    			break;
    		default:
    			break;
    		}
    	} else {
	    	targetSpeedX = Math.max(Math.min(Math.abs(OI.stick1.getRawAxis(0)) > deadZone ? OI.stick1.getRawAxis(0) : 0.0,
	    			speedLimit), -speedLimit);
	    	targetSpeedY = Math.max(Math.min(Math.abs(OI.stick1.getRawAxis(1)) > deadZone ? OI.stick1.getRawAxis(1) : 0.0,
	    			speedLimit), -speedLimit);
    	}
    	
    	targetSpeedZ = Math.max(Math.min(Math.abs(OI.stick1.getRawAxis(4)) > deadZone ? OI.stick1.getRawAxis(4) : 0.0,
    			speedLimit), -speedLimit);
    	
    	if (OI.stick1.getRawAxis(2) < deadZone) {
    		xSpeed = increaseSpeed(xSpeed, targetSpeedX, accelRate);
    		ySpeed = increaseSpeed(ySpeed, targetSpeedY, accelRate);
    		zSpeed = increaseSpeed(zSpeed, targetSpeedZ, accelRate);
    	} else {
    		xSpeed = targetSpeedX;
    		ySpeed = targetSpeedY;
    		zSpeed = targetSpeedZ;
    	}
    	
    	Robot.driveSystem.setSpeedX(xSpeed);
    	Robot.driveSystem.setSpeedY(ySpeed);
    	Robot.driveSystem.setSpeedZ(zSpeed);
    	Robot.driveSystem.drive();
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
