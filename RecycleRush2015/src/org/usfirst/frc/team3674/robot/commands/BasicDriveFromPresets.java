package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BasicDriveFromPresets extends Command {
	
	private double targetSpeedX;
	private double targetSpeedY;
	private double targetSpeedZ;
	private double endAccelMarker;
	private double startDecelMarker;
	private double endMarker;
	private int init_stepCount;
	private int stepCount;
	
    public BasicDriveFromPresets(double targetSpeedX, double targetSpeedY, double targetSpeedZ,
    		double endAccelMarker, double startDecelMarker, double endMarker) {
    	requires(Robot.driveSystem);
    	this.targetSpeedX = targetSpeedX;
    	this.targetSpeedY = targetSpeedY;
    	this.targetSpeedZ = targetSpeedZ;
    	this.endAccelMarker = endAccelMarker * 50.0;
    	this.startDecelMarker = startDecelMarker * 50.0;
    	this.endMarker = endMarker * 50.0;
    	this.init_stepCount = 0;
    }

    protected void initialize() {
    	stepCount = init_stepCount;
    }

    protected void execute() {
    	if (stepCount <= endAccelMarker) {	
    		Robot.driveSystem.setSpeedX(targetSpeedX * (stepCount / endAccelMarker));
    		Robot.driveSystem.setSpeedY(targetSpeedY * (stepCount / endAccelMarker));
    		Robot.driveSystem.setSpeedZ(targetSpeedZ * (stepCount / endAccelMarker));
    	} else if (stepCount >= startDecelMarker) {
    		Robot.driveSystem.setSpeedX(targetSpeedX * ((endMarker - stepCount) / (endMarker - startDecelMarker)));
    		Robot.driveSystem.setSpeedY(targetSpeedY * ((endMarker - stepCount) / (endMarker - startDecelMarker)));
    		Robot.driveSystem.setSpeedZ(targetSpeedZ * ((endMarker - stepCount) / (endMarker - startDecelMarker)));
    	}
    	
    	Robot.driveSystem.drive();
    	
    	stepCount++;
    }

    protected boolean isFinished() {
        return stepCount >= endMarker;
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
