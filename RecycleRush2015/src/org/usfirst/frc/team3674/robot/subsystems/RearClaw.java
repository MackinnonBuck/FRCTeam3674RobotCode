package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftRearClawFromJoysticks;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RearClaw extends Subsystem {
	
	private Talon motorTalon;
	private DigitalInput lowerSwitch;
	private DigitalInput upperSwitch;
	
	public RearClaw() {
		motorTalon = new Talon(RobotMap.rearClawMotor);
		lowerSwitch = new DigitalInput(RobotMap.clawLowLimitSwitch);
		upperSwitch = new DigitalInput(RobotMap.clawHighLimitSwitch);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new LiftRearClawFromJoysticks());
    }
    
    public void setSpeed(double speed) {
    	motorTalon.set(speed);
    }
    
    public boolean upperLimitReached() {
    	return !upperSwitch.get();
    }
    
    public boolean lowerLimitReached() {
    	return !lowerSwitch.get();
    }
}

