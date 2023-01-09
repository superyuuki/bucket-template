package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorNode;

public class FirstNode implements IBehaviorNode {

    final IBehaviorNode[] possibleBehaviors;
    final boolean[] failureFlags;

    public FirstNode(IBehaviorNode[] possibleBehaviors) {
        this.possibleBehaviors = possibleBehaviors;
        this.failureFlags = new boolean[possibleBehaviors.length];
        this.lastIteration = 0;
    }

    int lastIteration;


    @Override
    public Status process(int iteration) {

        if (iteration - lastIteration > 1) {
            //reset
        }

        for (int i = 0; i < possibleBehaviors.length; i++) {
            if (!failureFlags[i]) {
                Status subnodeStatus = possibleBehaviors[i].process(iteration);

                if (subnodeStatus == Status.FAILED) {
                    failureFlags[i] = true;
                }
            }
        }





        lastIteration = iteration;

    }

    void reset() {

    }
}
