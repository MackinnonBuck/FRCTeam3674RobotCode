package org.usfirst.frc.team3674.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HookContainerFromStep extends CommandGroup {
    
    public HookContainerFromStep() {
        addSequential(new LiftContainerClawFromPresets(0.5, 0.4));
        addSequential(new LiftContainerClawFromPresets(-0.5, 0.1));
        addSequential(new DriveFromPresets(1.0, 0.0, 0.0, 0.5, 1.5, 2.0));
        Timer.delay(1.5);
        addParallel(new LiftContainerClawFromPresets(-0.5, 0.6));
    }
}
