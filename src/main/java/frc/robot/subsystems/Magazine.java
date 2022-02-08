package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Magazine extends SubsystemBase {
	private Talon intakeMotor;
	private Talon frontMotor;
	private Talon backMotor;

	public Magazine() {
		this.intakeMotor = new Talon(Constants.Magazine.IntakeControllerPort);
		this.frontMotor = new Talon(Constants.Magazine.FrontControllerPort);
		this.backMotor = new Talon(Constants.Magazine.BackControllerPort);

		this.intakeMotor.setInverted(true);
		this.backMotor.setInverted(true);
	}

	public void RunMagazine(double intakeSpeed, double magazineSpeed) {
		this.intakeMotor.set(intakeSpeed);

		this.frontMotor.set(magazineSpeed);
		this.backMotor.set(magazineSpeed);
	}

	@Override
	public void periodic() { }
}
