package org.usfirst.frc.team3674.robot;

import org.usfirst.frc.team3674.robot.commands.LiftClips;
import org.usfirst.frc.team3674.robot.triggers.LeftTrigger;
import org.usfirst.frc.team3674.robot.triggers.RightTrigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI {
	
	public static Joystick stick1;
	public static Joystick stick2;
	public static Trigger leftTrigger;
	public static Trigger rightTrigger;
	
	public OI() {
		stick1 = new Joystick(1);
		stick2 = new Joystick(2);
		leftTrigger = new LeftTrigger();
		rightTrigger = new RightTrigger();
		rightTrigger.whenActive(new LiftClips());
		//leftTrigger.whenActive(new SetLiftMechanismTargetPosition(Robot.liftMechanism.getStartingPosition()));
	}
}

