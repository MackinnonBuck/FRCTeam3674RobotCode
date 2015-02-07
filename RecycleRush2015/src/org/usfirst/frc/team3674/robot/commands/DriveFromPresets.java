package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFromPresets extends Command {
	
	private double xDist;
	private double yDist;
	private double frontStartingPosition;
	private double rearStartingPosition;
	private double frontTargetPosition;
	private double rearTargetPosition;
	
    public DriveFromPresets(double power, double xDist, double yDist) {
        requires(Robot.driveSystem);
        this.xDist = xDist;
        this.yDist = yDist;
        frontStartingPosition = Robot.driveSystem.getFrontPosition();
        rearStartingPosition = Robot.driveSystem.getRearPosition();
        frontTargetPosition = 0.0;
        rearTargetPosition = 0.0;
    }

    protected void initialize() {
    	frontTargetPosition = (yDist / (6.0 * Math.PI)) + (xDist / (6.0 * Math.PI) / 2.0);
    	rearTargetPosition = (yDist / (6.0 * Math.PI)) - (xDist / (6.0 * Math.PI) / 2.0);
    }

    protected void execute() {
    	Robot.driveSystem.setFrontLeftTalonPower(Robot.driveSystem.getFrontPosition() - (frontTargetPosition - frontStartingPosition));
    	Robot.driveSystem.setFrontRightTalonPower(Robot.driveSystem.getFrontLeftTalonPower());
    	
    	Robot.driveSystem.setRearLeftTalonPower(Robot.driveSystem.getRearPosition() - (rearTargetPosition - rearStartingPosition));
    	Robot.driveSystem.setRearRightTalonPower(Robot.driveSystem.getRearLeftTalonPower());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
