package org.usfirst.frc.team3674.robot;

import org.usfirst.frc.team3674.robot.commands.DriveStraightToAutoZone;
import org.usfirst.frc.team3674.robot.commands.GetRecyclingContainer;
import org.usfirst.frc.team3674.robot.commands.PickUpYellowToteAndDriveToAutoZone;
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
	public static RearClaw rearClaw;
	private static Command autonomousCommand;
	private static SendableChooser autonomousChooser;
    
    public void robotInit() {
    	driveSystem = new DriveSystem();
    	liftMechanism = new LiftMechanism();
    	rearClaw = new RearClaw();
    	autonomousChooser = new SendableChooser();
    	autonomousChooser.addDefault("Get Recycling Container (Do Nothing)", new GetRecyclingContainer());
    	autonomousChooser.addObject("1 Yellow Tote or Container; Move To Auto Zone", new PickUpYellowToteAndDriveToAutoZone());
    	autonomousChooser.addObject("Move Straight To Auto Zone", new DriveStraightToAutoZone());
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
