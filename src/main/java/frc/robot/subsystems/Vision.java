package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.util.Units;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Talon;
import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;

/*
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatorCurrentLimitConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.PWMSpeedController;*/


public class Vision extends SubsystemBase {

    PhotonCamera camera;
    Talon turretMotor;
    XboxController controller;
    double rotationSpeed;
    double range;
    private Talon leftMotor;
	private Talon rightMotor;
    //DifferentialDrive drive;    //PIDController rotationController;
    public Vision(){

        this.camera = new PhotonCamera(Constants.CameraName);
        this.turretMotor = new Talon(Constants.TurretMotorPort);
        this.leftMotor = new Talon(Constants.DriveTrain.LeftControllerPort);
		this.rightMotor = new Talon(Constants.DriveTrain.RightControllerPort);

        this.controller = new XboxController(Constants.Controller1Port);
        this.leftMotor.setInverted(true);
        //drive = new DifferentialDrive(leftMotor, rightMotor);
        //rotationController = new PIDController(constants.AngularP, 0, constants.AngularD);

    }
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
        var result = camera.getLatestResult();
        if(result.hasTargets()){
            rotationSpeed = result.getBestTarget().getYaw();
            range =
                        PhotonUtils.calculateDistanceToTargetMeters(
                                Constants.CameraHeightInches* 0.0254,//CAMERA_HEIGHT_METERS,
                                Constants.CameraHeightInches * 0.0254,
                                Constants.CameraPitchRadians,
                                result.getBestTarget().getPitch()*3.14159/180);
        }
        else{       
            rotationSpeed = 0;
        }
        System.out.println(rotationSpeed/50);
        //double rangeSpeed = range/10 < 0.5? range/10: 0.5;
        leftMotor.set(-rotationSpeed/35);
        rightMotor.set(rotationSpeed/35);
        //drive.arcadeDrive(range/10, rotationSpeed/40);

    }
}
