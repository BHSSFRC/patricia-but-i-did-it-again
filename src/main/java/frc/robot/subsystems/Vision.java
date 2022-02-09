package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Talon;
import org.photonvision.PhotonCamera;
import frc.robot.Constants;
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
    //PIDController rotationController;
    public Vision(){

        this.camera = new PhotonCamera(Constants.CameraName);
        this.turretMotor = new Talon(Constants.TurretMotorPort);
        this.controller = new XboxController(Constants.Controller1Port);
        //rotationController = new PIDController(constants.AngularP, 0, constants.AngularD);

    }
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
        double rotationSpeed;
        var result = camera.getLatestResult();
            //camera.
            if(result.hasTargets()){
                rotationSpeed = result.getBestTarget().getYaw();
            }
            else{
                
                rotationSpeed = 0;
            }
            System.out.println(rotationSpeed/20);
                    this.turretMotor.set(rotationSpeed/20);

    }
}
