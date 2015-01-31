package org.usfirst.frc.team3674.robot.commands;

import org.usfirst.frc.team3674.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommand extends CommandGroup {
    
    
	public  AutonomousCommand() {
    	
		for(int i = 0; i < 3; i++){
			
			addSequential //pick up tote
			addSequential //move forward some distance
		
		}
		
		addSequential //turn left
		addSequential //back-up some distance
		addSequential //set down totes
		addSequential //strafe away5
		
	}
}

