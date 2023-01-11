package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

public class FirstRoutine implements IBehaviorRoutine {

    final IBehaviorRoutine[] possibleBehaviors;
    final boolean[] failureFlags;

    public FirstRoutine(IBehaviorRoutine[] possibleBehaviors) {
        this.possibleBehaviors = possibleBehaviors;
        this.failureFlags = new boolean[possibleBehaviors.length];
        this.lastIteration = 0;
    }

    int lastIteration;


    @Override
    public Status processTick(int iteration) {

        if (iteration - lastIteration > 1) {
            //reset
        }

        for (int i = 0; i < possibleBehaviors.length; i++) {
            if (!failureFlags[i]) {
                Status subnodeStatus = possibleBehaviors[i].processTick(iteration);

                if (subnodeStatus == Status.FAILED) {
                    failureFlags[i] = true;
                }
            }
        }





        lastIteration = iteration;

        return null;

    }

    void reset() {

    }
}
