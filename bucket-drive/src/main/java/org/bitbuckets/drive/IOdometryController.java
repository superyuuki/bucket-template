package org.bitbuckets.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;

public interface IOdometryController {

    void updateWithCurrentStates(SwerveModuleState[] states);

    Rotation2d estimateLastRotation();
    Translation2d estimateLastTranslation();

}
