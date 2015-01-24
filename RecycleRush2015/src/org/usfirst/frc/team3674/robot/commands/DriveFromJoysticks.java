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
    	Robot.driveSystem.robotDrive.mecanumDrive_Cartesian(OI.stick1.getRawAxis(2),
    			OI.stick1.getRawAxis(3), OI.stick1.getRawAxis(4), 0);
    }
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {
    }
    
    protected void interrupted() {
    }
}
