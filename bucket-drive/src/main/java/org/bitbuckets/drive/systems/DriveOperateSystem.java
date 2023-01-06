package org.bitbuckets.drive.systems;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.drive.DriveInput;
import org.bitbuckets.drive.IDriveController;
import org.bitbuckets.drive.IOdometryController;
import org.bitbuckets.lib.IKernel;
import org.bitbuckets.shared.DriveState;

public class DriveOperateSystem extends IKernel<DriveState> {

    final IDriveController driveControl;
    final IOdometryController odometryControl;
    final DriveInput input;

    public DriveOperateSystem(IDriveController driveControl, IOdometryController odometryControl, DriveInput input) {
        this.driveControl = driveControl;
        this.odometryControl = odometryControl;
        this.input = input;
    }

    @Override
    protected DriveState defaultState() {
        return DriveState.DRIVING;
    }

    @Override
    protected void teleopWithState(DriveState lastState, DriveState commandState) {
        if (commandState == DriveState.LOCK) {
            driveControl.doDriveWithStates(DriveConstants.LOCK);
        }

        if (commandState == DriveState.SLOW_DRIVING) {
            SwerveModuleState[] xyzPredictedStates = driveAt(input.getInputX(), input.getInputY(), input.getInputRot(), input.isSlowDrivePressed());

            driveControl.doDriveWithStates(xyzPredictedStates);

        }
    }

    @Override
    protected void startupWithState() {

    }

    @Override
    protected void shutdownWithState() {

    }

    SwerveModuleState[] driveAt(double x, double y, double rot, boolean slow)  {
        ChassisSpeeds speeds = ChassisSpeeds.fromFieldRelativeSpeeds( x, y, rot, odometryControl.estimateLastRotation() );
        SwerveModuleState[] states = DriveConstants.KINEMATICS.toSwerveModuleStates(speeds);
        SwerveDriveKinematics.desaturateWheelSpeeds(states, slow ? DriveConstants.SLOW_DRIVE_VELOCITY : DriveConstants.MAX_DRIVE_VELOCITY);

        return states;
    }
}
