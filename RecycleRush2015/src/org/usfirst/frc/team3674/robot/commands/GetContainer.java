package org.usfirst.frc.team3674.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GetContainer extends CommandGroup {
    
    public GetContainer() {
        addSequential(new LiftClipsFromPresets(1.0, -1.0));
        addSequential(new LiftClipsFromPresets(-1.0, 2.0));
    }
    
}
