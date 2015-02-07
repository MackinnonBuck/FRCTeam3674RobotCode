package org.usfirst.frc.team3674.robot;

import org.usfirst.frc.team3674.robot.commands.SpinCollectionWheelsInward;
import org.usfirst.frc.team3674.robot.commands.SpinCollectionWheelsOutward;
import org.usfirst.frc.team3674.robot.commands.StopCollectionWheels;
import org.usfirst.frc.team3674.robot.triggers.LeftTrigger;
import org.usfirst.frc.team3674.robot.triggers.RightTrigger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class OI {
	
	public static Joystick stick1;
	public static Joystick stick2;
	public static Trigger leftTrigger;
	public static Trigger rightTrigger;
	public static Button stick2_lb;
	public static Button stick2_rb;
	
	public OI() {
		stick1 = new Joystick(0);
		stick2 = new Joystick(1);
		leftTrigger = new LeftTrigger();
		rightTrigger = new RightTrigger();
		stick2_lb = new JoystickButton(stick2, 5);
		stick2_rb = new JoystickButton(stick2, 6);
		stick2_lb.whenPressed(new SpinCollectionWheelsOutward());
		stick2_rb.whenPressed(new SpinCollectionWheelsInward());
		stick2_lb.whenReleased(new StopCollectionWheels());
		stick2_rb.whenPressed(new StopCollectionWheels());
	}
	
}
