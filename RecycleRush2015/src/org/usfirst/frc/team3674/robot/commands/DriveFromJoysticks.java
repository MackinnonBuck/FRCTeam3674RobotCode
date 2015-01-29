package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveFromJoysticks extends Command {
	
    public DriveFromJoysticks() {
        requires(Robot.driveSystem);
    }
    
    protected void initialize() {
    }
    
    protected void execute() {
    	// NOTE: The raw axis values below may be erroneous. Test with caution.
    	Robot.driveSystem.setSpeedX(OI.stick1.getRawAxis(2));
    	Robot.driveSystem.setSpeedY(OI.stick1.getRawAxis(1));
    	Robot.driveSystem.setSpeedZ(OI.stick1.getRawAxis(4));
    	Robot.driveSystem.drive();
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
