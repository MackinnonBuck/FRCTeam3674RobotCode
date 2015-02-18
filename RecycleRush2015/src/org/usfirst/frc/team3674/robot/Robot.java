
package org.usfirst.frc.team3674.robot;

import org.usfirst.frc.team3674.robot.commands.AutonomousCommand;
import org.usfirst.frc.team3674.robot.subsystems.CollectionSystem;
import org.usfirst.frc.team3674.robot.subsystems.DriveSystem;
import org.usfirst.frc.team3674.robot.subsystems.LiftMechanism;
import org.usfirst.frc.team3674.robot.subsystems.RearClaw;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSystem driveSystem;
	public static LiftMechanism liftMechanism;
	public static CollectionSystem collectionSystem;
	public static RearClaw rearClaw;
	private static Command autonomousCommand;
    
    public void robotInit() {
    	driveSystem = new DriveSystem();
    	liftMechanism = new LiftMechanism();
    	collectionSystem = new CollectionSystem();
    	rearClaw = new RearClaw();
		oi = new OI();
        autonomousCommand = new AutonomousCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	driveSystem.setSafetyEnabled(false);
        if (autonomousCommand != null) autonomousCommand.start();
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	driveSystem.setSafetyEnabled(true);
        if (autonomousCommand != null) autonomousCommand.cancel();
    }
    
    public void disabledInit(){

    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
