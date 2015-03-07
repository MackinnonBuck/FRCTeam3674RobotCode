package org.usfirst.frc.team3674.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
	
	public static Joystick stick1;
	public static Joystick stick2;
	
	public OI() {
		stick1 = new Joystick(0);
		stick2 = new Joystick(1);
	}
	
}
