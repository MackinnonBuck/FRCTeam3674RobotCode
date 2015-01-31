package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MaintainClipPosition extends Command {

    public MaintainClipPosition() {
        requires(Robot.liftMechanism);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	// TODO: Code the balancing system.
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    }
}
