package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;
import org.usfirst.frc.team3674.robot.commands.LiftFromInput;

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
    	leftController = new PIDController(0.0, 0.25, 0.0,
    			new PIDSource() {
		
					@Override
					public double pidGet() {
						SmartDashboard.putNumber("Left Encoder Rate:", leftEncoder.getRate());
						return targetRate - leftEncoder.getRate() / maxRate;
					}
		    		
		    	},
		    	
    			new PIDOutput() {
					
					@Override
					public void pidWrite(double output) {
						SmartDashboard.putNumber("Left LM Output:", output);
						leftBottomLiftTalon.pidWrite(output);
					}
					
				});
    	leftController.setAbsoluteTolerance(10);
    	leftController.setContinuous(false);
    	leftController.enable();
    	rightController = new PIDController(0.0, 0.25, 0.0,
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
						SmartDashboard.putNumber("Right LM Output:", output);
						rightBottomLiftTalon.pidWrite(output);
					}
					
				});
    	rightController.setAbsoluteTolerance(10);
    	rightController.setContinuous(false);
    	rightController.enable();
    	targetRate = 0.0;
    	maxRate = 800.0;
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new LiftFromInput());
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
    
    public boolean lowLimitReached() {
    	return !lowLimitSwitch.get();
    }
    
    public boolean highLimitReached() {
    	return !highLimitSwitch.get();
    }
    
}
