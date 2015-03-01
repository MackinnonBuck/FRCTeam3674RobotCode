package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftRearClawFromJoysticks extends Command {
	
	private double deadZone;
	private double lowerSpeedLimit;
	private double upperSpeedLimit;
	
    public LiftRearClawFromJoysticks() {
    	requires(Robot.rearClaw);
    	deadZone = 0.15;
    	lowerSpeedLimit = 0.25;
    	upperSpeedLimit = 0.75;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Math.abs(OI.stick2.getRawAxis(5)) >= deadZone) {
    		Robot.rearClaw.setSpeed(Math.max(Math.min(OI.stick2.getRawAxis(5),
    				Robot.rearClaw.lowerLimitReached() ? 0.0 : lowerSpeedLimit),
    				Robot.rearClaw.upperLimitReached() ? 0.0 : -upperSpeedLimit));
    	} else {
    		Robot.rearClaw.setSpeed(0.0);
    	}
    	
    	//SmartDashboard.putBoolean("Lower Claw Limit Value:", Robot.rearClaw.lowerLimitReached());
    	//SmartDashboard.putBoolean("Upper Claw Limit Value:", Robot.rearClaw.upperLimitReached());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
