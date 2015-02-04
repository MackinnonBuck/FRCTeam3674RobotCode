package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFromPresets extends Command {
	
	private double xDist;
	private double yDist;
	private double frontTargetAngle;
	private double rearTargetAngle;
	
    public DriveFromPresets(double power, double xDist, double yDist) {
        requires(Robot.driveSystem);
        this.xDist = xDist;
        this.yDist = yDist;
        frontTargetAngle = 0.0;
        rearTargetAngle = 0.0;
    }

    protected void initialize() {
    	Robot.driveSystem.setXDistanceTraveled(0.0);
    	Robot.driveSystem.setYDistanceTraveled(0.0);
    	
    	frontTargetAngle = (yDist / (6.0 * Math.PI)) + (xDist / (6.0 * Math.PI) / 2.0);
    	rearTargetAngle = (yDist / (6.0 * Math.PI)) - (xDist / (6.0 * Math.PI) / 2.0);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
