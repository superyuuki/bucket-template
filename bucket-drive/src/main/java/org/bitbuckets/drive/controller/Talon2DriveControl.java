package org.bitbuckets.drive.controller;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.drive.IDriveController;

public class Talon2DriveControl implements IDriveController {



    @Override
    public SwerveModuleState[] queryCurrentStates() {
        return new SwerveModuleState[0];
    }

    @Override
    public void doDriveWithStates(SwerveModuleState[] states) {

    }
}
