package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
	private Talon leftMotor;
	private Talon rightMotor;

	public DriveTrain() {
		this.leftMotor = new Talon(Constants.DriveTrain.LeftControllerPort);
		this.rightMotor = new Talon(Constants.DriveTrain.RightControllerPort);

		this.leftMotor.setInverted(true);
	}

	public void TankDrive(double leftSpeed, double rightSpeed) {
		this.leftMotor.set(leftSpeed);
		this.rightMotor.set(rightSpeed);
	}

	@Override
	public void periodic() { }
}
