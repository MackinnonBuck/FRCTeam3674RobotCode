package org.usfirst.frc.team3674.robot.triggers;

import org.usfirst.frc.team3674.robot.OI;

import edu.wpi.first.wpilibj.buttons.Trigger;

public class LeftTrigger extends Trigger {
    
    public boolean get() {
        return OI.stick2.getRawAxis(3) < 0.0;
    }
}
