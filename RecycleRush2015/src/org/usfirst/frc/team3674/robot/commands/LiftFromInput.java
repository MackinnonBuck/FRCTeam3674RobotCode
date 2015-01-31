package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LiftFromInput extends Command {

    public LiftFromInput() {
        requires(Robot.liftMechanism);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.liftMechanism.setTargetSpeed(OI.stick2.getRawAxis(3) * 20.0);
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
