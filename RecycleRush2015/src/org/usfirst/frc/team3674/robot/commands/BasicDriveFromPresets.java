package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BasicDriveFromPresets extends Command {
	
	private double xSpeed;
	private double ySpeed;
	private double zSpeed;
	private double stepCount;
	
    public BasicDriveFromPresets(double xSpeed, double ySpeed, double zSpeed, double seconds) {
    	requires(Robot.driveSystem);
    	this.xSpeed = xSpeed;
    	this.ySpeed = ySpeed;
    	this.zSpeed = zSpeed;
    	this.stepCount = seconds * 50.0;
    }

    protected void initialize() {
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return stepCount == 0;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
