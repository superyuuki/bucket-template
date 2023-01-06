package org.bitbuckets.lib.log;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;

public interface DisplayType {

    IDisplay<Double> NUMBER_GRAPH = (c,i,o) -> c.addPersistent(i, o).withWidget(BuiltInWidgets.kGraph).getEntry();
    IDisplay<Double> NUMBER = (c,i,o) -> c.addPersistent(i,o).getEntry();
    IDisplay<Double> NUMBER_BAR = (c,i,o) -> c.addPersistent(i,o).withWidget(BuiltInWidgets.kNumberBar).getEntry();

}
