
package org.usfirst.frc.team3674.robot;

import org.usfirst.frc.team3674.robot.commands.AutonomousCommand;
import org.usfirst.frc.team3674.robot.subsystems.CollectionSystem;
import org.usfirst.frc.team3674.robot.subsystems.DriveSystem;
import org.usfirst.frc.team3674.robot.subsystems.LiftMechanism;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSystem driveSystem;
	public static LiftMechanism liftMechanism;
	public static CollectionSystem collectionSystem;
	private static Command autonomousCommand;
    
    public void robotInit() {
    	driveSystem = new DriveSystem();
    	liftMechanism = new LiftMechanism();
		oi = new OI();
        autonomousCommand = new AutonomousCommand();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
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
