package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

public class UntilRoutine implements IBehaviorRoutine {

    final IBehaviorRoutine child;

    public UntilRoutine(IBehaviorRoutine child) {
        this.child = child;
    }

    @Override
    public Status processTick(int iteration) {


        return null;
    }
}
