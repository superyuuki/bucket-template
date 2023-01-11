package org.bitbuckets.lib.behavior;

import edu.wpi.first.wpilibj.TimedRobot;
import org.bitbuckets.lib.IBehaviorRoutine;

public class AutonomousRoutine implements IBehaviorRoutine {

    final TimedRobot robot;
    final IBehaviorRoutine[] nodes;

    public AutonomousRoutine(TimedRobot robot, IBehaviorRoutine... nodes) {
        this.robot = robot;
        this.nodes = nodes;
    }

    @Override
    public Status processTick(int iteration) {

        if (robot.isTeleop()) {
            return Status.SUCCESS; //It doesn't matter, if we made it this far this node is done processing
        }

        //repeat children until it's teleop time

        //we don't care about what they report UNLESS they all report failure
        for (int i = 0; i < nodes.length; i++) {
            nodes[i].processTick(iteration);
        }

        return Status.NEEDS_PROCESSING;
    }
}
