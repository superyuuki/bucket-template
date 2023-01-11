package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

import java.util.function.Supplier;

public class CheckRoutine implements IBehaviorRoutine {

    final Supplier<Boolean> isAutonomous;

    public CheckRoutine(Supplier<Boolean> isAutonomous) {
        this.isAutonomous = isAutonomous;
    }

    @Override
    public Status processTick(int iteration) {
        if (isAutonomous.get()) {
            return Status.SUCCESS;
        }

        return Status.FAILED;
    }
}
