package org.usfirst.frc.team3674.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousCommand extends CommandGroup {
    
    
	public  AutonomousCommand() {
		if(SmartDashboard.getString("Autonomous Mode:") == "1"){
			
		}
		if(SmartDashboard.getString("Autonomous Mode:") == "2"){
			
		}
		if(SmartDashboard.getString("Autonomous Mode:") == "3"){
			
		}
	}
}

