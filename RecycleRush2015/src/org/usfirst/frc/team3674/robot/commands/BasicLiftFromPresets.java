package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BasicLiftFromPresets extends Command {
	
	private double speed;
	private double endMarker;
	private int stepCount;
	
    public BasicLiftFromPresets(double speed, double seconds) {
        requires(Robot.liftMechanism);
        this.speed = speed;
        this.endMarker = seconds * 50.0;
        this.stepCount = 0;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.liftMechanism.setPower(speed);
    	if (endMarker > 0.0) stepCount++;
    }

    protected boolean isFinished() {
        return (Robot.liftMechanism.highLimitReached() && speed < 0) || (Robot.liftMechanism.lowLimitReached() && speed > 0)
        		|| speed == 0.0 || stepCount > endMarker;
    }

    protected void end() {
    	Robot.liftMechanism.setPower(0.0);
    }

    protected void interrupted() {
    }
}
