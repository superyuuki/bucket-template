package org.bitbuckets.lib.log;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;

public interface IDisplay<T> {

    GenericEntry display(ShuffleboardContainer container, String id, T initial);

}
