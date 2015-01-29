package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftFromInput;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftMechanism extends Subsystem {
	
	private Talon liftTalon;
	
	public LiftMechanism() {
		liftTalon = new Talon(RobotMap.liftTalonPort);
		liftTalon.set(0.0);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new LiftFromInput());
    }
    
    public void setSpeed(double speed) {
    	liftTalon.set(speed);
    }
    
}

