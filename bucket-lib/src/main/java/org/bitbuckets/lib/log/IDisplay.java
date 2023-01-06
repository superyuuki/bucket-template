package org.bitbuckets.lib.log;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;

public interface IDisplay<T> {

    NetworkTableEntry display(ShuffleboardContainer container, String id, T initial);

}
