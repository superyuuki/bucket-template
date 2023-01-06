package org.bitbuckets.lib.log;

import edu.wpi.first.networktables.NetworkTableEntry;

public interface IUpdate<T> {

    void update(NetworkTableEntry entry, T object);

}
