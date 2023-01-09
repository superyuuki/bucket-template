package org.bitbuckets.drive;

import com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SdsModuleConfigurations;
import com.swervedrivespecialties.swervelib.SwerveModule;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;

import java.util.function.Supplier;

import static com.swervedrivespecialties.swervelib.Mk4SwerveModuleHelper.GearRatio.L2;
import static com.swervedrivespecialties.swervelib.SdsModuleConfigurations.MK4_L2;

public interface DriveConstants {

    double MAX_DRIVE_VELOCITY = 6380.0 / 60.0 * MK4_L2.getDriveReduction() * MK4_L2.getWheelDiameter() * Math.PI;
    double SLOW_DRIVE_VELOCITY = MAX_DRIVE_VELOCITY * 0.75;

    //TODO divide by 2
    double WIDTH = 0.6096 / 2;
    double BASE = 0.7712 / 2;

    double DRIVE_REDUCTION = (14.0 / 50.0) * (27.0 / 17.0) * (15.0 / 45.0);
    double DRIVE_GEARING = 1 / DRIVE_REDUCTION;

    double ROTATION_REDUCTION = (14.0 / 50.0) * (10.0 / 60.0);
    double ROTATION_GEARING = 1 / ROTATION_REDUCTION;

    SimpleMotorFeedforward FF = new SimpleMotorFeedforward(0.65292, 2.3053, 0.37626); //converts velocity to voltage

    Translation2d[] KINEMATICS_TRANSLATIONS = new Translation2d[] {
            new Translation2d(WIDTH, BASE),
            new Translation2d(WIDTH, -BASE),
            new Translation2d(-WIDTH, BASE),
            new Translation2d(-WIDTH, -BASE)
    };

    SwerveDriveKinematics KINEMATICS = new SwerveDriveKinematics(
            KINEMATICS_TRANSLATIONS
    );

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
        SwerveModule[] modules = new SwerveModule[] { frontLeft, frontRight, backLeft, backRight };
        return modules;
    };


}
