package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;

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
    }
    
    public void setSpeed(double speed) {
    	liftTalon.set(speed);
    }
    
    public void liftSpeed(){
    	if(liftEncoder.getStopped() == true) {
    		speedIncrease++;
    		this.setSpeed(speedIncrease);
    		this.liftSpeed();
    	} else {
    		//speedIncrease = new stoppingSpeed;
    	}
    }
}
