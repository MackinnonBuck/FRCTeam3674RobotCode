package org.usfirst.frc.team3674.robot;

import org.usfirst.frc.team3674.robot.commands.DoNothing;
import org.usfirst.frc.team3674.robot.commands.DriveStraightToAutoZone;
import org.usfirst.frc.team3674.robot.commands.GetContainer;
import org.usfirst.frc.team3674.robot.commands.HookContainerFromStep;
import org.usfirst.frc.team3674.robot.commands.PickUpYellowToteAndDriveToAutoZone;
import org.usfirst.frc.team3674.robot.subsystems.ContainerClaw;
import org.usfirst.frc.team3674.robot.subsystems.DriveSystem;
import org.usfirst.frc.team3674.robot.subsystems.LiftMechanism;

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
	public static ContainerClaw containerClaw;
	private static Command autonomousCommand;
	private static SendableChooser autonomousChooser;
    
    public void robotInit() {
    	driveSystem = new DriveSystem();
    	liftMechanism = new LiftMechanism();
    	containerClaw = new ContainerClaw();
    	autonomousChooser = new SendableChooser();
    	autonomousChooser.addDefault("Do Nothing", new DoNothing());
    	autonomousChooser.addObject("Get Container", new GetContainer());
    	autonomousChooser.addObject("Hook Container From Step", new HookContainerFromStep());
    	autonomousChooser.addObject("Pick Up Yellow Tote And Drive To Auto Zone", new PickUpYellowToteAndDriveToAutoZone());
    	autonomousChooser.addObject("Drive Straight To Auto Zone", new DriveStraightToAutoZone());
		oi = new OI();
		
		SmartDashboard.putData("Autonomous Mode", autonomousChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	autonomousCommand = (Command) autonomousChooser.getSelected();
    	liftMechanism.enablePIDControllers();
        autonomousCommand.start();
    }
    
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	if (autonomousCommand != null) autonomousCommand.cancel();
    	liftMechanism.enablePIDControllers();
    }
    
    public void disabledInit(){
    	liftMechanism.resetPIDControllers();
    }
    
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
    
}
