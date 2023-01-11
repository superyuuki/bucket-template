package org.bitbuckets.lib.log;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import java.util.function.Consumer;

public class SimpleLoggable implements Consumer<Integer> {

    final NetworkTableEntry entry;

    public SimpleLoggable(NetworkTableEntry entry) {
        this.entry = entry;
    }

    public double signal() {
        return 0.0;
    }

    @Override
    public void accept(Integer integer) {
        entry.setDouble(integer.doubleValue());


    }
}
