package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BasicLiftFromInput extends Command {
	
	private double deadZone;
	
    public BasicLiftFromInput() {
        requires(Robot.liftMechanism);
        deadZone = 0.1;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Math.abs(OI.stick2.getRawAxis(1)) <= deadZone) {
    		Robot.liftMechanism.setPower(OI.stick2.getRawAxis(1));
    	} else {
    		Robot.liftMechanism.setPower(0.0);
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
