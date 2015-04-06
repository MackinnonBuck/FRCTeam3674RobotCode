package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftFromInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftMechanism extends Subsystem {
	
	private Talon rightBottomLiftTalon;
	private Talon leftBottomLiftTalon;
	private DigitalInput lowLimitSwitch;
	private DigitalInput highLimitSwitch;

	public LiftMechanism() {
		rightBottomLiftTalon = new Talon(RobotMap.rightBottomLiftTalonPort);
		leftBottomLiftTalon = new Talon(RobotMap.leftBottomLiftTalonPort);
    	lowLimitSwitch = new DigitalInput(RobotMap.lowLimitSwitch);
    	highLimitSwitch = new DigitalInput(RobotMap.highLimitSwitch);
		rightBottomLiftTalon.set(0.0);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new LiftFromInput());
    }
    
    public void setPower(double power) {
    	leftBottomLiftTalon.set(power);
    	rightBottomLiftTalon.set(power);
    }
    
    public boolean lowLimitReached() {
    	return !lowLimitSwitch.get();
    }
    
    public boolean highLimitReached() {
    	return !highLimitSwitch.get();
    }
    
}
