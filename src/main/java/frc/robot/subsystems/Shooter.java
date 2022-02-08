package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
	private Talon topMotor;
	private Talon bottomMotor;

	public Shooter() {
		this.topMotor = new Talon(Constants.Shooter.TopWheelControllerPort);
		this.bottomMotor = new Talon(Constants.Shooter.BottomWheelControllerPort);
	}

	public void Shoot(double speed) {
		this.topMotor.set(speed);
		this.bottomMotor.set(speed);
	}

	@Override
	public void periodic() { }
}
