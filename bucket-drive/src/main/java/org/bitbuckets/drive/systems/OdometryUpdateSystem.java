package org.bitbuckets.drive.systems;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import org.bitbuckets.drive.IDriveController;
import org.bitbuckets.drive.IOdometryController;
import org.bitbuckets.lib.ISystem;

/**
 * key system responsible for feeding odometry control the drive control's current states in order to give odometry
 * more data to be accurate with
 */
public class OdometryUpdateSystem implements ISystem {

    final IDriveController driveControl;
    final IOdometryController odometryControl;

    public OdometryUpdateSystem(IDriveController driveControl, IOdometryController odometryControl) {
        this.driveControl = driveControl;
        this.odometryControl = odometryControl;
    }

    @Override
    public void startup() {
        //noop
    }

    @Override
    public void teleop(long delta) {
        SwerveModuleState[] states = driveControl.queryCurrentStates();
        odometryControl.updateWithCurrentStates(states);
    }

    @Override
    public void shutdown() {
        //noop
    }
}
