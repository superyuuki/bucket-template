package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

public class WaitRoutine implements IBehaviorRoutine {

    final int ticks;

    public WaitRoutine(int ticks) {
        this.ticks = ticks;
    }

    @Override
    public Status processTick(int iteration) {
        return null;
    }
}
