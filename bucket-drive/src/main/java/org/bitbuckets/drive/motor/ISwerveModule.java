package org.bitbuckets.drive.motor;

import edu.wpi.first.math.geometry.Rotation2d;

public interface ISwerveModule {

    double queryCurrentVelocityMetersPerSecond();
    double queryCurrentAngVelocityRadiansPerSecond();

    Rotation2d queryCurrentRotation();



    void commandSetpointValues(double velocity, Rotation2d rotation2d);

}
