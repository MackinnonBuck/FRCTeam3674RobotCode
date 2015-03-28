package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftFromInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftMechanism extends Subsystem {
	
	private Talon rightBottomLiftTalon;
	private Talon leftBottomLiftTalon;
	private Talon rightTopLiftTalon;
	private Talon leftTopLiftTalon;
	private DigitalInput lowLimitSwitch;
	private DigitalInput highLimitSwitch;

	public LiftMechanism() {
		rightBottomLiftTalon = new Talon(RobotMap.rightBottomLiftTalonPort);
		leftBottomLiftTalon = new Talon(RobotMap.leftBottomLiftTalonPort);
		rightTopLiftTalon = new Talon(RobotMap.rightTopLiftTalonPort);
		leftTopLiftTalon = new Talon(RobotMap.leftTopLiftTalonPort);
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
    	leftTopLiftTalon.set(power);
    	rightTopLiftTalon.set(power);
    }
    
    public boolean lowLimitReached() {
    	return !lowLimitSwitch.get();
    }
    
    public boolean highLimitReached() {
    	return !highLimitSwitch.get();
    }
    
}
