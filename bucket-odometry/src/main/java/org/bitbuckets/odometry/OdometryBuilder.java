package org.bitbuckets.odometry;

import edu.wpi.first.math.geometry.Pose2d;

import java.util.List;
import java.util.function.Supplier;

public class OdometryBuilder {

    final List<Supplier<Pose2d>> poseSuppliers;

    public OdometryBuilder(List<Supplier<Pose2d>> poseSuppliers) {
        this.poseSuppliers = poseSuppliers;
    }

    public OdometryBuilder submitPoseSupplier(Supplier<Pose2d> periodicPoseSupplier) {
        this.poseSuppliers.add(periodicPoseSupplier);

        return this;
    }


}
