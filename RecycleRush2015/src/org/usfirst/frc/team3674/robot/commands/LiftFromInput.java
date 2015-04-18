package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftFromInput extends Command {
	
	private double deadZone;
	
    public LiftFromInput() {
        requires(Robot.liftMechanism);
        deadZone = 0.2;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Math.abs(OI.stick2.getRawAxis(1)) >= deadZone) {
    		/** /Robot.liftMechanism.setTargetRate(OI.stick2.getRawAxis(1));/**/
    		/**/
    		Robot.liftMechanism.setTargetRate(Math.max(Math.min(OI.stick2.getRawAxis(1),
    				Robot.liftMechanism.lowLimitReached() ? 0.0 : 1.0),
    				Robot.liftMechanism.highLimitReached() ? 0.0 : -1.0));
    		/**/
    	} else {
    		Robot.liftMechanism.setTargetRate(0.0);
    	}
    	
    	SmartDashboard.putBoolean("Low Limit Reached", Robot.liftMechanism.lowLimitReached());
		SmartDashboard.putNumber("Encoder Rate:", Robot.liftMechanism.getEncoderRate());
    	/** /
    	if (Math.abs(OI.stick2.getRawAxis(1)) >= deadZone) {
    		Robot.liftMechanism.setPower(Math.max(Math.min(OI.stick2.getRawAxis(1),
    				Robot.liftMechanism.lowLimitReached() ? 0.0 : 1.0),
    				Robot.liftMechanism.highLimitReached() ? 0.0 : -1.0));
    	} else {
    		Robot.liftMechanism.setPower(0.0);
    	}
    	/**/
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
