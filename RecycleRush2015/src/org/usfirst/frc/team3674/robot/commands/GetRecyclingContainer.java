package org.usfirst.frc.team3674.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GetRecyclingContainer extends CommandGroup {
    
    public GetRecyclingContainer() {
        addSequential(new LiftFromPresets(1.0, -1.0));
        addSequential(new LiftFromPresets(-1.0, 4.5));
    }
    
}
