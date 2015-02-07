package org.usfirst.frc.team3674.robot.subsystems;

import org.usfirst.frc.team3674.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CollectionSystem extends Subsystem {
    
    private Talon wheelTalon;
    
    public CollectionSystem() {
    	wheelTalon = new Talon(RobotMap.collectionSystemMotorPort);
    }

    public void initDefaultCommand() {
        
    }
    
    public void setPower(double power) {
    	wheelTalon.set(power);
    }
    
}

