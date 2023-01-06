package org.bitbuckets.drive.controller;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import org.bitbuckets.drive.IOdometryController;

public class SimOdometryControl implements IOdometryController {



    @Override
    public void updateWithCurrentStates(SwerveModuleState[] states) {

    }

    @Override
    public Rotation2d estimateLastRotation() {
        return null;
    }

    @Override
    public Translation2d estimateLastTranslation() {
        //todo tons of annoying kinematics

        return null;
    }
}
