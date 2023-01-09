package org.bitbuckets.drive.behavior;

import org.bitbuckets.drive.DriveInput;
import org.bitbuckets.drive.IDriveController;
import org.bitbuckets.drive.IOdometryController;
import org.bitbuckets.drive.nodes.DriveStandardNode;
import org.bitbuckets.lib.IBehaviorFactory;
import org.bitbuckets.lib.IBehaviorNode;
import org.bitbuckets.lib.behavior.SequenceNode;

public class DriveBehavior implements IBehaviorFactory {

    final DriveInput input;
    final IDriveController driveController;
    final IOdometryController odometryController;

    public DriveBehavior(DriveInput input, IDriveController driveController, IOdometryController odometryController) {
        this.input = input;
        this.driveController = driveController;
        this.odometryController = odometryController;
    }

    @Override
    public IBehaviorNode produceAutonomousBehavior(Tools tools) {
        return null;
    }

    @Override
    public IBehaviorNode produceTeleopBehavior(Tools tools) {

        new SequenceNode(



                new DriveStandardNode(input, driveController, odometryController)


        );



        return null;
    }
}
