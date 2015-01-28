package org.usfirst.frc.team3674.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftMechanism extends Subsystem {
	
	public Talon lift;
	
		public LiftMechanism() {
			lift = new Talon(1);
			lift.set(0.0);	
		}
		
		
		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
            	
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

