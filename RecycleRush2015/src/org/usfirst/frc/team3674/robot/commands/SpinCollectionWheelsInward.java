package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinCollectionWheelsInward extends Command {

    public SpinCollectionWheelsInward() {
    	requires(Robot.collectionSystem);
    }

    protected void initialize() {
    	Robot.collectionSystem.setPower(1.0);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    }
}
