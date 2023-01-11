package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

/**
 * node that will only return complete when all of it's children behavior are complete
 */
public class SequenceRoutine implements IBehaviorRoutine {


    @Override
    public Status processTick(int iteration) {
        return null;
    }
}
