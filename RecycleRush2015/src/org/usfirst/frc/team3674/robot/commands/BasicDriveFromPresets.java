package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BasicDriveFromPresets extends Command {
	
	private double speedX;
	private double speedY;
	private double speedZ;
	private double acceleration;
	private double stepCount;
	
    public BasicDriveFromPresets(double speedX, double speedY, double speedZ, double acceleration, double seconds) {
    	requires(Robot.driveSystem);
    	this.speedX = speedX;
    	this.speedY = speedY;
    	this.speedZ = speedZ;
    	this.acceleration = acceleration;
    	this.stepCount = Math.abs(seconds * 50.0);
    }

    protected void initialize() {
    	Robot.driveSystem.setSpeedX(speedX / acceleration);
    	Robot.driveSystem.setSpeedY(speedY / acceleration);
    	Robot.driveSystem.setSpeedZ(speedZ / acceleration);
    	Robot.driveSystem.drive();
    }

    protected void execute() {
    	Robot.driveSystem.setSpeedX(Math.max(Math.min(Robot.driveSystem.getSpeedX() + speedX / acceleration, 1.0), -1.0));
    	Robot.driveSystem.setSpeedY(Math.max(Math.min(Robot.driveSystem.getSpeedY() + speedY / acceleration, 1.0), -1.0));
    	Robot.driveSystem.setSpeedZ(Math.max(Math.min(Robot.driveSystem.getSpeedZ() + speedZ / acceleration, 1.0), -1.0));
    	stepCount--;
    }

    protected boolean isFinished() {
        return stepCount == 0;
    }

    protected void end() {
    	Robot.driveSystem.setSpeedX(0.0);
    	Robot.driveSystem.setSpeedY(0.0);
    	Robot.driveSystem.setSpeedZ(0.0);
    	Robot.driveSystem.drive();
    }

    protected void interrupted() {
    }
}
