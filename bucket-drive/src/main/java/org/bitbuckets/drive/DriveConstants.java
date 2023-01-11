package org.bitbuckets.drive;

import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;

import java.util.function.Supplier;

import static com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper.GearRatio.L2;

public interface DriveConstants {

    //TODO divide by 2
    double REVOLUTION = (2.0 * Math.PI);
    double WIDTH = 0.6096 / 2; //width of bot ?
    double BASE = 0.7712 / 2; //base of bot ?
    double WHEEL_DIAMETER_METERS = 0.10033;

    double DRIVE_REDUCTION = (14.0 / 50.0) * (27.0 / 17.0) * (15.0 / 45.0); //motor -> axle
    double DRIVE_STEP_UP = 1 / DRIVE_REDUCTION; //axle -> motor

    double ROTATION_REDUCTION = (14.0 / 50.0) * (10.0 / 60.0);
    double ROTATION_STEP_UP = 1 / ROTATION_REDUCTION;

    //motor rotation -> axle rotation -> meters -> circle
    double DRIVE_FACTOR_POS = DRIVE_REDUCTION * WHEEL_DIAMETER_METERS * Math.PI;
    double DRIVE_FACTOR_VEL = DRIVE_FACTOR_POS / 60.0;

    double TURN_FACTOR_HALL_POS = DRIVE_REDUCTION * REVOLUTION; //give me radians!
    double TURN_FACTOR_HALL_VEL = TURN_FACTOR_HALL_POS / 60; //give me radians / time! or something

    double TURN_FACTOR_ABS_POS = (1/3.3) * REVOLUTION; //give me radians!

    double MAX_DRIVE_VELOCITY = 6380.0 * DRIVE_FACTOR_VEL;
    double SLOW_DRIVE_VELOCITY = MAX_DRIVE_VELOCITY * 0.75;
    double MAX_ANG_VELOCITY = Math.hypot(WIDTH / 2.0, BASE / 2.0);



    SimpleMotorFeedforward FF = new SimpleMotorFeedforward(0.65292, 2.3053, 0.37626); //converts velocity to voltage

    Translation2d[] KINEMATICS_TRANSLATIONS = new Translation2d[] {
            new Translation2d(WIDTH, BASE),
            new Translation2d(WIDTH, -BASE),
            new Translation2d(-WIDTH, BASE),
            new Translation2d(-WIDTH, -BASE)
    };

    SwerveDriveKinematics KINEMATICS = new SwerveDriveKinematics(KINEMATICS_TRANSLATIONS);

    SwerveModuleState[] LOCK = new SwerveModuleState[] {
            new SwerveModuleState(0, Rotation2d.fromDegrees(45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(45))
    };

    Supplier<SwerveModule[]> STATE_MAKER = () -> {

        SwerveModule frontLeft = Mk4SwerveModuleHelper.createFalcon500(L2, 1, 2, 9, -Math.toRadians(232.55));
        SwerveModule frontRight = Mk4SwerveModuleHelper.createFalcon500(L2, 7, 8, 12, -Math.toRadians(331.96 - 180));
        SwerveModule backLeft = Mk4SwerveModuleHelper.createFalcon500(L2, 5, 6, 11, -Math.toRadians(255.49));
        SwerveModule backRight = Mk4SwerveModuleHelper.createFalcon500(L2, 3, 4, 10, -Math.toRadians(70.66 + 180));
        return new SwerveModule[] { frontLeft, frontRight, backLeft, backRight };
    };


}
