package org.bitbuckets.lib;

import org.bitbuckets.lib.behavior.TryRoutine;

public interface IBehaviorRoutine {

    Status processTick(int iteration);

    enum Status {
        NEEDS_PROCESSING,
        SUCCESS,
        FAILED
    }

    IBehaviorRoutine EMPTY = new TryRoutine();

}
