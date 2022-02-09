package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Magazine;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Vision;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class RobotContainer {
	//private final DriveTrain driveTrain = new DriveTrain();
	//private final Magazine magazine = new Magazine();
	//private final Shooter shooter = new Shooter();

	//private final Drive driveCommand = new Drive(driveTrain, magazine, shooter);
	public final Vision vision = new Vision();
	public RobotContainer() {
		OI.getInstance();

		String[] SDNumbers = {
            "Patricia/Magazine Power",
			"Patricia/Intake Power",
			"Patricia/Shooter Power",
			"Patricia/Drive Power",
			"Patricia/Turn Power",
        };

        for (String doubleName : SDNumbers) {
            if (!SmartDashboard.containsKey(doubleName)) {
                SmartDashboard.putNumber(doubleName, 1);
                SmartDashboard.setPersistent(doubleName);
            }
        }
		
		//CommandScheduler.getInstance().setDefaultCommand(driveTrain, driveCommand);
		//CommandScheduler.getInstance().setDefaultCommand(magazine, driveCommand);
		//CommandScheduler.getInstance().setDefaultCommand(shooter, driveCommand);

		//driveCommand.schedule();

		configureButtonBindings();
	}

	private void configureButtonBindings() {
	}
}
