package org.bitbuckets.lib;

import edu.wpi.first.wpilibj.TimedRobot;

public class BucketTimedRobot extends TimedRobot {

    final ISystem[] orderedSystemsCollection;

    public BucketTimedRobot(ISystem[] orderedSystemsCollection) {
        this.orderedSystemsCollection = orderedSystemsCollection;
    }

    @Override
    public void robotInit() {
        for (ISystem logic : orderedSystemsCollection) {
            logic.startup();
        }
    }

    long lastNanos = System.nanoTime();

    @Override
    public void robotPeriodic() {
        long now = System.nanoTime();
        long delta = now - lastNanos;
        lastNanos = now;

        for (ISystem logic : orderedSystemsCollection) {
            logic.teleop(delta);
        }
    }

    @Override
    public void teleopExit() {
        for (ISystem logic : orderedSystemsCollection) {
            logic.shutdown();
        }
    }
}
