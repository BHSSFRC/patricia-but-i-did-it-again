package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Magazine;
import frc.robot.subsystems.Shooter;

public class Drive extends CommandBase {
	private DriveTrain driveTrain;
	private Magazine magazine;
	private Shooter shooter;
	
	public Drive(DriveTrain driveTrain, Magazine magazine, Shooter shooter) {
		this.driveTrain = driveTrain;
		this.magazine = magazine;
		this.shooter = shooter;

		this.addRequirements(this.driveTrain);
		this.addRequirements(this.magazine);
		this.addRequirements(this.shooter);
	}

	@Override
	public void initialize() {
	}

	@Override
	public void execute() {
		double magazinePower = SmartDashboard.getNumber("Patricia/Magazine Power", 0.5);
		double intakePower = SmartDashboard.getNumber("Patricia/Intake Power", 0.5);
		double shooterPower = SmartDashboard.getNumber("Patricia/Shooter Power", 0.5);

		this.driveTrain.TankDrive(OI.getInstance().leftSpeed(), OI.getInstance().rightSpeed());
		this.shooter.Shoot(OI.getInstance().shooterPower() * shooterPower);

		if (OI.getInstance().runMagazine()) {
			this.magazine.RunMagazine(intakePower, magazinePower);
		} else if (OI.getInstance().reverseMagazine()) {
			this.magazine.RunMagazine(-intakePower, -magazinePower);
		} else {
			this.magazine.RunMagazine(0, 0);
		}
	}

	@Override
	public void end(boolean interrupted) {
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
