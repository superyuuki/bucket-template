package org.bitbuckets.lib;

public interface IBehaviorFactory {

    interface Tools {

    }

    IBehaviorNode produceAutonomousBehavior(Tools tools);
    IBehaviorNode produceTeleopBehavior(Tools tools);

}
