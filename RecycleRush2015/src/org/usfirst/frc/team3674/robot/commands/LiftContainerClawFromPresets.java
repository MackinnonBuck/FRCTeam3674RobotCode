package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftContainerClawFromPresets extends Command {

	private double init_speed;
	private double init_endMarker;
	private int init_stepCount;
	private double speed;
	private double endMarker;
	private int stepCount;
	
    public LiftContainerClawFromPresets(double speed, double seconds) {
        requires(Robot.containerClaw);
        this.init_speed = speed;
        this.init_endMarker = seconds * 50.0;
        this.init_stepCount = 0;
    }

    protected void initialize() {
    	speed = init_speed;
    	endMarker = init_endMarker;
    	stepCount = init_stepCount;
    }

    protected void execute() {
    	Robot.containerClaw.setSpeed(speed);
    	if (endMarker > 0.0) stepCount++;
    }

    protected boolean isFinished() {
    	return speed == 0.0 || init_endMarker < 0.0 || (stepCount > endMarker && endMarker >= 0.0);
    }

    protected void end() {
    	Robot.containerClaw.setSpeed(0.0);
    }

    protected void interrupted() {
    }
    
}
