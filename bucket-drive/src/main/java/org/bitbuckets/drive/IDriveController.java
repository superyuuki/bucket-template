package org.bitbuckets.drive;

import edu.wpi.first.math.kinematics.SwerveModuleState;

public interface IDriveController {

    SwerveModuleState[] queryCurrentStates();
    void doDriveWithStates(SwerveModuleState[] states);

}
