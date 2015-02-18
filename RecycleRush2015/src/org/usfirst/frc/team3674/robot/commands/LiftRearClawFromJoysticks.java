package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftRearClawFromJoysticks extends Command {
	
	private double deadZone;
	
    public LiftRearClawFromJoysticks() {
    	requires(Robot.rearClaw);
    	deadZone = 0.1;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Math.abs(OI.stick2.getRawAxis(5)) >= deadZone) {
    		Robot.rearClaw.setSpeed(OI.stick2.getRawAxis(5));
    	} else {
    		Robot.rearClaw.setSpeed(0.0);
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
