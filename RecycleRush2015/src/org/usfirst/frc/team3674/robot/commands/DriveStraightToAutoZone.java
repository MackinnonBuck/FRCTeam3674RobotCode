package org.usfirst.frc.team3674.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DriveStraightToAutoZone extends CommandGroup {
    
    public  DriveStraightToAutoZone() {
    	addSequential(new DriveFromPresets(0.0, -0.5, 0.0, 1.0, 3.0, 4.0));
    }
}
