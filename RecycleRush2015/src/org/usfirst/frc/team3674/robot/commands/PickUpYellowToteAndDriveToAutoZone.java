package org.usfirst.frc.team3674.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PickUpYellowToteAndDriveToAutoZone extends CommandGroup {
    
    
	public  PickUpYellowToteAndDriveToAutoZone() {
		/*
		if(SmartDashboard.getString("Autonomous Mode:") == "1"){
			addSequential(new BasicDriveFromPresets(0, -0.5, 0, 2));
			addSequential(new BasicDriveFromPresets(0, 0, -0.5, 1));
			addSequential(new BasicDriveFromPresets(0, -1, 0, 0.5));
			addSequential(new BasicDriveFromPresets(-0.25, 0, 0, 0.25));
			addSequential(new return 0); //lift totes
			addSequential(new BasicDriveFromPresets(0.25, 0, 0, 0.25));
		}
		if(SmartDashboard.getString("Autonomous Mode:") == "2"){
			
		}
		if(SmartDashboard.getString("Autonomous Mode:") == "3"){
			
		}
		*/
		addSequential(new BasicLiftFromPresets(1.0, -1.0));
		addSequential(new BasicLiftFromPresets(-1.0, 1.0));
		addSequential(new BasicDriveFromPresets(0.0, 0.0, 0.5, 0.0, 1.5, 1.5));
		addSequential(new BasicDriveFromPresets(0.0, 1.0, 0.0, 1.0, 4.0, 5.0));
		addSequential(new BasicLiftFromPresets(1.0, -1.0));
		addSequential(new BasicDriveFromPresets(0.0, -0.15, 0.0, 0.5, 0.5, 1.0));
	}
}