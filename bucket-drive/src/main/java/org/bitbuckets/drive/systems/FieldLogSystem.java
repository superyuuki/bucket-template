package org.bitbuckets.drive.systems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.drive.IDriveController;
import org.bitbuckets.drive.IOdometryController;
import org.bitbuckets.lib.ISystem;

public class FieldLogSystem implements ISystem {

    final IOdometryController odometryControl; //needed to estimate where the robot's base is
    final IDriveController driveControl; //needed to draw each wheel

    public FieldLogSystem(IOdometryController odometryControl, IDriveController driveControl) {
        this.odometryControl = odometryControl;
        this.driveControl = driveControl;
    }

    final Field2d field2d = new Field2d();

    @Override
    public void startup() {

    }

    @Override
    public void teleop(long delta) {
        Pose2d robot = new Pose2d(odometryControl.estimateLastTranslation(), odometryControl.estimateLastRotation());

        field2d.setRobotPose(robot);

        //bound states - modules will always be attached to the robot, only the angles will be accurate to the simulation
        SwerveModuleState[] states = driveControl.queryCurrentStates();

        for (int i = 0; i < states.length; i++) {
            Translation2d position = robot.getTranslation().plus(DriveConstants.KINEMATICS_TRANSLATIONS[i]);
            Rotation2d rotation = states[i].angle;
            field2d.getObject("bound-module-" + (i + 1) ).setPose(new Pose2d(position, rotation));
        }

    }

    @Override
    public void shutdown() {

    }
}
