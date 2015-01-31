package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftFromInput extends Command {
	
	private boolean targetAcquired;
	
    public LiftFromInput() {
        requires(Robot.liftMechanism);
        targetAcquired = false;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Math.abs(OI.stick2.getRawAxis(3)) <= 0.1) {
    		targetAcquired = false;
		    Robot.liftMechanism.setTargetSpeed(Math.max(Math.min(OI.stick2.getRawAxis(3) * 20.0, 1.0), -1.0));
    	} else if (targetAcquired) {
    		Robot.liftMechanism.setTargetSpeed(Robot.liftMechanism.getTargetPosition() - Robot.liftMechanism.getPosition());
    	} else if (OI.stick2.getRawAxis(3) == 0) {
			targetAcquired = true;
			Robot.liftMechanism.setTargetPosition(Robot.liftMechanism.getPosition());
		}
    	
    	Robot.liftMechanism.setPower(
    			Math.max(Math.min(Robot.liftMechanism.getPower() + ((Robot.liftMechanism.getTargetSpeed() - Robot.liftMechanism.getSpeed()) / Robot.liftMechanism.getThreshold()),
    			1.0), -1.0));
}

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    }
}
