package org.bitbuckets.drive.controller.module;

import edu.wpi.first.math.geometry.Rotation2d;
import org.bitbuckets.drive.controller.module.ISwerveModule;

public class TalonSwerveModule implements ISwerveModule {
    @Override
    public double queryCurrentAccumulatedPositionMeters() {
        return 0;
    }

    @Override
    public Rotation2d queryCurrentRotation() {
        return null;
    }

    @Override
    public void commandSetpointValues(double velocitySetpoint_metersPerSecond, double turnSetpoint_radians) {

    }
}
