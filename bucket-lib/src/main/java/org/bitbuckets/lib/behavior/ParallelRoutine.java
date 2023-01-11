package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

//Run everything at once unless a failure of EVERYTHING or success of EVERYTHING
public class ParallelRoutine implements IBehaviorRoutine {

    final IBehaviorRoutine[] nodes;

    public ParallelRoutine(IBehaviorRoutine... nodes) {
        this.nodes = nodes;
    }

    @Override
    public Status processTick(int iteration) {
        return null;
    }
}
