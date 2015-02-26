package org.usfirst.frc.team3674.robot;

import org.usfirst.frc.team3674.robot.commands.BasicDriveFromPresets;
import org.usfirst.frc.team3674.robot.commands.BasicLiftFromPresets;
import org.usfirst.frc.team3674.robot.commands.PickUpYellowToteAndDriveToAutoZone;
import org.usfirst.frc.team3674.robot.subsystems.CollectionSystem;
import org.usfirst.frc.team3674.robot.subsystems.DriveSystem;
import org.usfirst.frc.team3674.robot.subsystems.LiftMechanism;
import org.usfirst.frc.team3674.robot.subsystems.RearClaw;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSystem driveSystem;
	public static LiftMechanism liftMechanism;
	public static CollectionSystem collectionSystem;
	public static RearClaw rearClaw;
	private static Command autonomousCommand;
	private static SendableChooser autonomousChooser;
    
    public void robotInit() {
    	driveSystem = new DriveSystem();
    	liftMechanism = new LiftMechanism();
    	collectionSystem = new CollectionSystem();
    	rearClaw = new RearClaw();
    	autonomousChooser = new SendableChooser();
    	autonomousChooser.addDefault("1 Yellow Tote; Move To Auto Zone", new PickUpYellowToteAndDriveToAutoZone());
    	autonomousChooser.addObject("Custom Drive", new BasicDriveFromPresets(0.0, 0.5, 0.0, 2.0, 4.0, 5.0));
    	autonomousChooser.addObject("Custom Pickup (Lower)", new BasicLiftFromPresets(1.0, -1.0));
    	autonomousChooser.addObject("Custom Pickup (Raise)", new BasicLiftFromPresets(-1.0, 2.0));
		oi = new OI();
		SmartDashboard.putData("Autonomous Mode", autonomousChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = (Command) autonomousChooser.getSelected();
        autonomousCommand.start();
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
