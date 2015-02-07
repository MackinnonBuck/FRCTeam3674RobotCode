package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveFromJoysticks extends Command {
	
	private double leftStickX;
	private double leftStickY;
	private double rightStickX;
	private double accelRate;
	
    public DriveFromJoysticks() {
        requires(Robot.driveSystem);
        leftStickX = 0.0;
        leftStickY = 0.0;
        rightStickX = 0.0;
        accelRate = 25.0;
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	leftStickX = Math.max(Math.min(leftStickX + OI.stick1.getRawAxis(0) / accelRate, 1.0), -1.0);
    	leftStickY = Math.max(Math.min(leftStickY + OI.stick1.getRawAxis(1) / accelRate, 1.0), -1.0);
    	rightStickX = Math.max(Math.min(rightStickX + OI.stick1.getRawAxis(4) / accelRate, 1.0), -1.0);
    	
    	Robot.driveSystem.setSpeedX(leftStickX);
    	Robot.driveSystem.setSpeedY(leftStickY);
    	Robot.driveSystem.setSpeedZ(rightStickX);
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
}
