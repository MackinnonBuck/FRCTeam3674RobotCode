package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftClipsFromInput;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LiftMechanism extends Subsystem {
	
	private Talon rightBottomLiftTalon;
	private Talon leftBottomLiftTalon;
	private DigitalInput lowLimitSwitch;
	private DigitalInput highLimitSwitch;
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private double p;
	private double i;
	private double d;
	private PIDController leftController;
	private PIDController rightController;
	private double targetRate;
	private double maxRate;

	public LiftMechanism() {
		leftBottomLiftTalon = new Talon(RobotMap.leftBottomLiftTalonPort);
		leftBottomLiftTalon.set(0.0);
		rightBottomLiftTalon = new Talon(RobotMap.rightBottomLiftTalonPort);
		rightBottomLiftTalon.set(0.0);
    	lowLimitSwitch = new DigitalInput(RobotMap.lowLimitSwitch);
    	highLimitSwitch = new DigitalInput(RobotMap.highLimitSwitch);
    	leftEncoder = new Encoder(RobotMap.liftEncoderLeftPortA, RobotMap.liftEncoderLeftPortB);
    	rightEncoder = new Encoder(RobotMap.liftEncoderRightPortA, RobotMap.liftEncoderRightPortB);
    	p = 0.0;
    	i = 0.25;
    	d = 0.0;
    	leftController = new PIDController(p, i, d,
    			new PIDSource() {
		
					@Override
					public double pidGet() {
						SmartDashboard.putNumber("Left Encoder Rate:", leftEncoder.getRate());
						return -targetRate - leftEncoder.getRate() / maxRate;
					}
		    		
		    	},
		    	
    			new PIDOutput() {
					
					@Override
					public void pidWrite(double output) {
						if (lowLimitReached() && output > 0.0)
							output = 0.0;
						
						leftBottomLiftTalon.pidWrite(output);
						SmartDashboard.putNumber("Left LM Output:", output);
					}
					
				});
    	leftController.setAbsoluteTolerance(10);
    	leftController.setContinuous(false);
    	rightController = new PIDController(p, i, d,
    			new PIDSource() {
					
					@Override
					public double pidGet() {
						SmartDashboard.putNumber("Right Encoder Rate:", rightEncoder.getRate());
						return targetRate - rightEncoder.getRate() / maxRate;
					}
					
				},
				
    			new PIDOutput() {
					
					@Override
					public void pidWrite(double output) {
						if (lowLimitReached() && output < 0.0)
							output = 0.0;
						
						rightBottomLiftTalon.pidWrite(output);
						SmartDashboard.putNumber("Right LM Output:", output);

					}
					
				});
    	rightController.setAbsoluteTolerance(10);
    	rightController.setContinuous(false);
    	targetRate = 0.0;
    	maxRate = 800.0;
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new LiftClipsFromInput());
    }
	
    public void setTargetRate(double speed) {
    	this.targetRate = speed;
    }
    
    public double getTargetRate() {
    	return this.targetRate;
    }
    
    public double getEncoderRate() {
    	return leftEncoder.getRate();
    }
    
    public void setSpeed(double speed) {
    	rightBottomLiftTalon.set(speed);
    	leftBottomLiftTalon.set(speed);
    }
    
    public void setP(double p) {
    	this.p = p;
    	leftController.setPID(p, i, d);
    	rightController.setPID(p, i, d);
    }
    
    public void setI(double i) {
    	this.i = i;
    	leftController.setPID(p, i, d);
    	rightController.setPID(p, i, d);
    }
    
    public void setD(double d) {
    	this.d = d;
    	leftController.setPID(p, i, d);
    	rightController.setPID(p, i, d);
    }
    
    public void resetPIDControllers() {
    	leftController.reset();
    	rightController.reset();
    }
    
    public void enablePIDControllers() {
    	leftController.enable();
    	rightController.enable();
    }
    
    public boolean lowLimitReached() {
    	return !lowLimitSwitch.get();
    }
    
    public boolean highLimitReached() {
    	return !highLimitSwitch.get();
    }
    
}
