package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.OI;
import org.usfirst.frc.team3674.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftMechanism extends Subsystem {
	
	public Talon liftTalon;
	
	public LiftMechanism() {
		liftTalon = new Talon(RobotMap.liftTalonPort);
		liftTalon.set(0.0);
		if(OI.stick2.getRawAxis(3) >= 0.0) {
			
		} else if(OI.stick2.getRawAxis(3) <= 0.0) {
			
		}
	}
	
		
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
            	
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

