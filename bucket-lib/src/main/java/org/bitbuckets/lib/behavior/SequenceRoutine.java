package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorRoutine;

/**
 * node that will only return complete when all of it's children behavior are complete
 */
public class SequenceRoutine implements IBehaviorRoutine {

    final IBehaviorRoutine[] nodes;

    int index = 0;

    public SequenceRoutine(IBehaviorRoutine... nodes) {
        this.nodes = nodes;
    }

    @Override
    public Status process() {

        Status status = nodes[index].processTick();

        if (status == Status.NEEDS_PROCESSING) {
            return Status.NEEDS_PROCESSING;
        }

        if (status == Status.SUCCESS) {
            index++;

            if (index == nodes.length) {
                index = 0;
                return Status.SUCCESS;
            }

            return Status.NEEDS_PROCESSING;
        }

        if (status == Status.FAILED) {
            index = 0;
            return Status.FAILED;
        }

        throw new IllegalStateException("what");
    }
}
