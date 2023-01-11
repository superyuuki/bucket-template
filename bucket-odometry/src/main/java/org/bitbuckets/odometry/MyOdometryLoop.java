package org.bitbuckets.odometry;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import org.bitbuckets.drive.controller.IDriveController;
import org.bitbuckets.lib.process.IProcess;

public class MyOdometryLoop implements IOdometryController, IProcess {

    final Gyro gyro;
    final IDriveController driveController;
    final SwerveDrivePoseEstimator estimator;

    public MyOdometryLoop(Gyro gyro, IDriveController driveController, SwerveDrivePoseEstimator estimator) {
        this.gyro = gyro;
        this.driveController = driveController;
        this.estimator = estimator;
    }

    private void loop() { estimator.update(gyro.getRotation2d(), driveController.queryCurrentStates()); }

    @Override
    public ProcessId setup(ProcessSetup processSetup) {
        processSetup.registerLoop(this::loop);

        return OdometryProcesses.ODOMETRY;
    }

    @Override
    public Pose2d estimatePose() {
        return estimator.getEstimatedPosition();
    }

    @Override
    public void depositVisionPose(Pose2d pose2d, double timestamp) {
        estimator.addVisionMeasurement(pose2d, timestamp);
    }


}
