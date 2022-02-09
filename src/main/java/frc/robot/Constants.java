package frc.robot;

public final class Constants {
    public final static double CameraHeightInches = 30;
    public final static double TargetHeightInches = 50;
    public final static double CameraPitchRadians = 1;
    public final static String CameraName = "USB_Camera";

    public final static double AngularD = 0.0;
    public final static double AngularP = 0.1;
    public final static int Controller1Port = 0;
    public final static int TurretMotorPort = 2;

    public static final class OI {
        public static final int XboxPort = 2;
    }

    public static final class DriveTrain {
        public static final int LeftControllerPort = 0;
        public static final int RightControllerPort = 1;
    }

    public static final class Magazine {
        public static final int IntakeControllerPort = 5;
        public static final int BackControllerPort = 6;
        public static final int FrontControllerPort = 4;
    }

    public static final class Shooter {
        public static final int TopWheelControllerPort = 3;
        public static final int BottomWheelControllerPort = 2;
    }
}
