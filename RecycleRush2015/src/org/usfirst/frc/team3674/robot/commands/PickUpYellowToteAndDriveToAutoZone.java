package org.usfirst.frc.team3674.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickUpYellowToteAndDriveToAutoZone extends CommandGroup {
    
	public PickUpYellowToteAndDriveToAutoZone() {
		addSequential(new LiftClipsFromPresets(1.0, -1.0));
		addSequential(new LiftClipsFromPresets(-1.0, 1.75));
		addSequential(new DriveFromPresets(0.0, 0.0, 0.5, 0.5, 1.25, 1.8));
		addSequential(new DriveFromPresets(0.0, -0.5, 0.0, 1.0, 3.0, 4.0));
		addSequential(new LiftClipsFromPresets(1.0, -1.0));
	}
	
}