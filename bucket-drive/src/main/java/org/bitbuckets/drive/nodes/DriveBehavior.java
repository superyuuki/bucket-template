package org.bitbuckets.drive.nodes;

import org.bitbuckets.drive.DriveInput;
import org.bitbuckets.drive.IDriveController;
import org.bitbuckets.drive.IOdometryController;
import org.bitbuckets.lib.IBehaviorFactory;
import org.bitbuckets.lib.IBehaviorRoutine;
import org.bitbuckets.lib.behavior.CheckRoutine;
import org.bitbuckets.lib.behavior.XDriveRoutine;
import org.bitbuckets.lib.behavior.SequenceRoutine;
import org.bitbuckets.lib.behavior.TryRoutine;

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
    public IBehaviorRoutine produceBehavior(Tools tools) {


        IBehaviorRoutine driveAtControlsRoutine = null; //instant
        IBehaviorRoutine autoBalanceRoutine = null; //takes time to complete
        IBehaviorRoutine otherBehaviorNode = null;


        IBehaviorRoutine auto = new SequenceRoutine(
                new CheckRoutine()
        )


        IBehaviorRoutine teleop = new TryRoutine(
                new SequenceRoutine(
                        new CheckRoutine(input::isAimDrivePressed),
                        new DriveStandardRoutine(input, driveController, odometryController)
                ),
                new SequenceRoutine(
                        new CheckRoutine(input::isSlowDrivePressed),
                        new DriveStandardRoutine(input, driveController, odometryController) //TODO make it slow
                ),
                new SequenceRoutine(
                        new CheckRoutine(input::isUserInputZeroed),
                        new XDriveRoutine()
                )
        );










        return null;
    }
}
