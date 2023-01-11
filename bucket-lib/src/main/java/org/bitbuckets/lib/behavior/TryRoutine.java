package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

/**
 * Try each of these things
 */
public class TryRoutine implements IBehaviorRoutine {

    final IBehaviorRoutine[] nodes;

    public TryRoutine(IBehaviorRoutine... nodes) {
        this.nodes = nodes;
    }

    @Override
    public Status processTick(int iteration) {
        return null;
    }
}
