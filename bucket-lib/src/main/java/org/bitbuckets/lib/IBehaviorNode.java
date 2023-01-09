package org.bitbuckets.lib;

import java.util.List;

public interface IBehaviorNode {

    Status process(int iteration);

    enum Status {
        NEEDS_PROCESSING,
        COMPLETE,
        FAILED
    }

}
