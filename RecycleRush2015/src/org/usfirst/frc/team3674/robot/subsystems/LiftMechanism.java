package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.MaintainClipPosition;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftMechanism extends Subsystem {
	
	private Talon liftTalon;
	private Encoder liftEncoder;
	public double speedIncrease = 0;
	
	public LiftMechanism() {
		liftTalon = new Talon(RobotMap.liftTalonPort);
    	liftEncoder = new Encoder(RobotMap.encoderPort1, RobotMap.encoderPort2);
		liftTalon.set(0.0);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new MaintainClipPosition());
    }
    
    public void liftSpeed(){
    	if(liftEncoder.getStopped() == true) {
    		speedIncrease++;
    		this.setPower(speedIncrease);
    		this.liftSpeed();
    	} else {
    		//speedIncrease = new stoppingSpeed;
    	}
    }
    
    public void setPower(double power) {
    	liftTalon.set(power);
    }
    
    public double getPower() {
    	return liftTalon.get();
    }
    
    public double getSpeed() {
    	// Insert code here. Any existing code below is a placeholder.
    	return 0.0;
    }
    
    public double getTargetSpeed() {
    	// Insert code here. Any existing code below is a placeholder.
    	return 0.0;
    }
    
    public double getRateOfAcceleration() {
    	// Insert code here. Any existing code below is a placeholder.
    	return 0.0;
    }
    
    public void setTargetPosition(int targetPosition) {
    	// Insert code here. Any existing code below is a placeholder.
    }
    
    public int getStartingPosition() {
    	// Insert code here. Any existing code below is a placeholder.
    	return 0;
    }
    
    public int getAngle() {
    	// Insert code here. Any existing code below is a placeholder.
    	return 0;
    }
    
}
