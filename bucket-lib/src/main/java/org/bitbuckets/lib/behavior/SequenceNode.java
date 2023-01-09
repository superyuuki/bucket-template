package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorNode;

/**
 * node that will only return complete when all of it's children behavior are complete
 */
public class SequenceNode implements IBehaviorNode {

    final IBehaviorNode[] nodes;

    int index = 0;

    public SequenceNode(IBehaviorNode... nodes) {
        this.nodes = nodes;
    }

    @Override
    public Status process() {

        Status status = nodes[index].process();

        if (status == Status.NEEDS_PROCESSING) {
            return Status.NEEDS_PROCESSING;
        }

        if (status == Status.COMPLETE) {
            index++;

            if (index == nodes.length) {
                index = 0;
                return Status.COMPLETE;
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
