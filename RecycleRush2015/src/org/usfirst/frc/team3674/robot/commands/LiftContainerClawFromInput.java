package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftContainerClawFromInput extends Command {
	
	private double deadZone;
	private double lowerSpeedLimit;
	private double upperSpeedLimit;
	
    public LiftContainerClawFromInput() {
    	requires(Robot.containerClaw);
    	deadZone = 0.15;
    	lowerSpeedLimit = 0.75;
    	upperSpeedLimit = 0.75;
    }

    protected void initialize() {
    }
    
    protected void execute() {
    	if (Math.abs(OI.stick2.getRawAxis(5)) >= deadZone) {
    		if (Math.abs(OI.stick2.getRawAxis(5)) >= deadZone) {
    			Robot.containerClaw.setSpeed((
    					Math.max(Math.min(OI.stick2.getRawAxis(5), lowerSpeedLimit), -upperSpeedLimit)));
    		}
    	} else {
    		Robot.containerClaw.setSpeed(0.0);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
