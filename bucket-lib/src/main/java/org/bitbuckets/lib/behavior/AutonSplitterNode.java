package org.bitbuckets.lib.behavior;

import org.bitbuckets.lib.IBehaviorNode;

import java.util.function.Supplier;

public class AutonSplitterNode implements IBehaviorNode {

    final Supplier<Boolean> isAutonomous;
    final IBehaviorNode[] autoAndTeleop;

    public AutonSplitterNode(Supplier<Boolean> isAutonomous, IBehaviorNode[] autoAndTeleop) {
        this.isAutonomous = isAutonomous;
        this.autoAndTeleop = autoAndTeleop;
    }


    @Override
    public Status process(int iteration) {

        //can this fail?


        return null;
    }
}
