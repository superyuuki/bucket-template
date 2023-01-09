package org.bitbuckets.drive.motor;

import edu.wpi.first.math.geometry.Rotation2d;

public class SimSwerveModule implements ISwerveModule {


    @Override
    public double queryCurrentVelocityMetersPerSecond() {
        return 20.0;
    }

    @Override
    public double queryCurrentAngVelocityRadiansPerSecond() {
        return 130;
    }

    @Override
    public Rotation2d queryCurrentRotation() {
        return null;
    }

    @Override
    public void commandSetpointValues(double velocity, Rotation2d rotation2d) {

    }
}
