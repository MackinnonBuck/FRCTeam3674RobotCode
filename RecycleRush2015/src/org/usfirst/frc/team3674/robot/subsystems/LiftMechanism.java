package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.BasicLiftFromInput;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftMechanism extends Subsystem {
	
	private Talon rightLiftTalon;
	private Talon leftLiftTalon;
	private Encoder liftEncoder;
	private double targetSpeed;
	private double threshold;
	private double threeTotes;
	private int targetPosition;

	public LiftMechanism() {
		rightLiftTalon = new Talon(RobotMap.rightLiftTalonPort);
		leftLiftTalon = new Talon(RobotMap.leftLiftTalonPort);
    	liftEncoder = new Encoder(RobotMap.liftEncoderPort1, RobotMap.liftEncoderPort2);
		rightLiftTalon.set(0.0);
		targetSpeed = 0;
		threshold = 0;
		targetPosition = 0;
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new BasicLiftFromInput());
    }
        
    public void setPower(double power) {
    	leftLiftTalon.set(power);
    	rightLiftTalon.set(power);
    }
    
    public double getPower() {
    	return rightLiftTalon.get();
    }
    
    public double getSpeed() {
    	return liftEncoder.getRate();
    }
    
    public double getTargetSpeed() {
    	return targetSpeed;
    }
    
    public void setTargetSpeed(double targetSpeed) {
    	this.targetSpeed = targetSpeed;
    }
    
	public double getThreshold() {
		return threshold;
	}
    
	public double getThreeTotes() {
		return threeTotes;
	}

	public void setThreeTotes(double threeTotes) {
		this.threeTotes = threeTotes;
	}
	
    public void setTargetPosition(int targetPosition) {
    	this.targetPosition = targetPosition;
    }
    
    public int getTargetPosition() {
    	return targetPosition;
    }
    
    public int getStartingPosition() {
    	return 0;
    }
    
    public int getPosition() {
    	return liftEncoder.getRaw();
    }
    
}
