package org.bitbuckets.drive.controller;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import org.bitbuckets.drive.IDriveController;
import org.bitbuckets.drive.motor.ISwerveModule;
import org.bitbuckets.drive.motor.SimSwerveModule;
import org.bitbuckets.drive.motor.SparkSwerveModule;

public class GenericDriveController implements IDriveController {

    final ISwerveModule[] swerveModules;

    public GenericDriveController(ISwerveModule[] swerveModules) {
        this.swerveModules = swerveModules;
    }

    @Override
    public SwerveModuleState[] queryCurrentStates() {

        SwerveModuleState[] array = new SwerveModuleState[swerveModules.length];

        for (int i = 0; i < swerveModules.length; i++) {
            array[i] = new SwerveModuleState(swerveModules[i].queryCurrentVelocityMetersPerSecond(), swerveModules[i].queryCurrentRotation())
        }

        return array;

    }

    @Override
    public void doDriveWithStates(SwerveModuleState[] states) {



    }

}
