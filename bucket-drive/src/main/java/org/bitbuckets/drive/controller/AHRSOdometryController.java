package org.bitbuckets.drive.controller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.bitbuckets.drive.IOdometryController;

class AHRSOdometryController implements IOdometryController {

    final Gyro gyro;
    final SwerveDriveOdometry swerveDriveOdometry;

    public AHRSOdometryController(Gyro gyro, SwerveDriveOdometry swerveDriveOdometry) {
        this.gyro = gyro;
        this.swerveDriveOdometry = swerveDriveOdometry;
    }

    @Override
    public void updateWithCurrentStates(SwerveModuleState[] states) {
        swerveDriveOdometry.update(gyro.getRotation2d(), states);
    }

    @Override
    public Rotation2d estimateLastRotation() { //todo not continuos
        return swerveDriveOdometry.getPoseMeters().getRotation();
    }

    @Override
    public Translation2d estimateLastTranslation() {
        return swerveDriveOdometry.getPoseMeters().getTranslation();
    }
}
