package org.bitbuckets.drive.nodes;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.drive.DriveInput;
import org.bitbuckets.drive.IDriveController;
import org.bitbuckets.drive.IOdometryController;
import org.bitbuckets.lib.IBehaviorRoutine;

public class DriveStandardRoutine implements IBehaviorRoutine {

    final DriveInput input;
    final IDriveController driveController;
    final IOdometryController odometryController;

    public DriveStandardRoutine(DriveInput input, IDriveController driveController, IOdometryController odometryController) {
        this.input = input;
        this.driveController = driveController;
        this.odometryController = odometryController;
    }


    @Override
    public Status processTick(int s) {

        Rotation2d rotation2d = odometryController.estimateLastRotation();
        SwerveModuleState[] states = DriveConstants.KINEMATICS.toSwerveModuleStates(new ChassisSpeeds(input.getInputX(), input.getInputY(), input.getInputRot()));
        for (int i = 0; i < states.length; i++) {
            states[i] = SwerveModuleState.optimize(states[i], rotation2d);
        }

        driveController.doDriveWithStates(states);
        return Status.SUCCESS;
    }
}
