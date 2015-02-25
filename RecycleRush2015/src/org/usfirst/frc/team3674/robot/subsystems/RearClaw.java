package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftRearClawFromJoysticks;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RearClaw extends Subsystem {
	
	private Talon motorTalon;
	private DigitalInput limitSwitch;
	
	public RearClaw() {
		motorTalon = new Talon(RobotMap.rearClawMotor);
		limitSwitch = new DigitalInput(RobotMap.clawLimitSwitch);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new LiftRearClawFromJoysticks());
    }
    
    public void setSpeed(double speed) {
    	motorTalon.set(-speed);
    }
    
    public boolean limitReached() {
    	return !limitSwitch.get();
    }
    
}

