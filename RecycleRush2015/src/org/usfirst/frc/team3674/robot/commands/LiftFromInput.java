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
    	if (OI.leftTrigger.get()) {
    		Robot.liftMechanism.setSpeed(-1.0);
    	} else if (OI.rightTrigger.get()) {
    		Robot.liftMechanism.setSpeed(1.0);
    	} else {
    		Robot.liftMechanism.setSpeed(0.0);
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
