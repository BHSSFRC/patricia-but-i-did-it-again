package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OI {
    private static OI Instance = new OI();

    private XboxController xboxController;

    private OI() {
        xboxController = new XboxController(Constants.OI.XboxPort);
    }

    public static OI getInstance() {
        return Instance;
    }

    public double leftSpeed() {
        //return xboxController.getY(Hand.kLeft);
        return (xboxController.getY(Hand.kLeft) * SmartDashboard.getNumber("Patricia/Drive Power", 0.75)) - (xboxController.getX(Hand.kRight) * SmartDashboard.getNumber("Patricia/Turn Power", 0.5));
    }

    public double rightSpeed() {
        //return xboxController.getY(Hand.kRight);
        return (xboxController.getY(Hand.kLeft) * SmartDashboard.getNumber("Patricia/Drive Power", 0.75)) + (xboxController.getX(Hand.kRight) * SmartDashboard.getNumber("Patricia/Turn Power", 0.5));
    }

    public boolean runMagazine() {
        return xboxController.getBumper(Hand.kLeft);
    }

    public boolean reverseMagazine() {
        return xboxController.getBumper(Hand.kRight);
    }

    public double shooterPower() {
        return xboxController.getTriggerAxis(Hand.kLeft);
    }
}
