package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BasicLiftFromInput extends Command {
	
	private double deadZone;
	
    public BasicLiftFromInput() {
        requires(Robot.liftMechanism);
        deadZone = 0.2;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Math.abs(OI.stick2.getRawAxis(1)) >= deadZone) {
    		Robot.liftMechanism.setPower(Math.max(Math.min(OI.stick2.getRawAxis(1),
    				Robot.liftMechanism.lowLimitReached() ? 0.0 : 1.0),
    				Robot.liftMechanism.highLimitReached() ? 0.0 : -1.0));
    	} else {
    		Robot.liftMechanism.setPower(0.0);
    	}
    	
    	if (Robot.liftMechanism.lowLimitReached()) {
    		OI.stick2.setRumble(RumbleType.kRightRumble, 1);
    	} else {
    		OI.stick2.setRumble(RumbleType.kRightRumble, 0);
    	}
    	
    	SmartDashboard.putBoolean("Low Limit Value:", Robot.liftMechanism.lowLimitReached());
    	SmartDashboard.putBoolean("High Limit Value:", Robot.liftMechanism.highLimitReached());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
