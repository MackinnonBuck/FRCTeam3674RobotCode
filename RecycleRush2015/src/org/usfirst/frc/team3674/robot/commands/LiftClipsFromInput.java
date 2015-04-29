package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftClipsFromInput extends Command {
	
	private double maxSpeed;
	private double deadZone;
	
    public LiftClipsFromInput() {
        requires(Robot.liftMechanism);
        deadZone = 0.2;
        maxSpeed = 1.0;
    }

    protected void initialize() {
    }

    protected void execute() {
    	maxSpeed = OI.stick2.getRawAxis(3) < 0.75 ? 1.0 : 0.5;
    	
    	if (Math.abs(OI.stick2.getRawAxis(1)) >= deadZone) {
    		Robot.liftMechanism.setTargetRate(Math.max(Math.min(OI.stick2.getRawAxis(1) * maxSpeed,
    				Robot.liftMechanism.lowLimitReached() ? 0.0 : 1.0),
    				Robot.liftMechanism.highLimitReached() ? 0.0 : -1.0));
    	} else {
    		Robot.liftMechanism.setTargetRate(0.0);
    	}
    	
    	SmartDashboard.putBoolean("Low Limit Reached", Robot.liftMechanism.lowLimitReached());
		SmartDashboard.putNumber("Encoder Rate:", Robot.liftMechanism.getEncoderRate());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.liftMechanism.setTargetRate(0.0);
    }

    protected void interrupted() {
    }
}
