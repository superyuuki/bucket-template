package org.bitbuckets.odometry;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;

public interface IOdometryController {

    Pose2d estimatePose();

    void depositVisionPose(Pose2d pose2d, double timestamp);

}
