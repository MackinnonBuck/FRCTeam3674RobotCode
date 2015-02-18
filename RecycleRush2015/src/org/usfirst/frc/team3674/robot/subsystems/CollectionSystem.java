package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CollectionSystem extends Subsystem {
    
    private Talon leftWheelTalon;
    private Talon rightWheelTalon;
    
    public CollectionSystem() {
    	leftWheelTalon = new Talon(RobotMap.collectionSystemLeftMotor);
    	rightWheelTalon = new Talon(RobotMap.collectionSystemRightMotor);
    }

    public void initDefaultCommand() {
        
    }
    
    public void setPower(double power) {
    	leftWheelTalon.set(power);
    	rightWheelTalon.set(power);
    }
    
}

