package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftContainerClawFromInput;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ContainerClaw extends Subsystem {
	
	private Talon motorTalon;
	
	public ContainerClaw() {
		motorTalon = new Talon(RobotMap.rearClawMotor);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new LiftContainerClawFromInput());
    }
    
    public void setSpeed(double speed) {
    	motorTalon.set(-speed);
    }
}

