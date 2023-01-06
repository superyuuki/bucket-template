package org.bitbuckets.lib;

public interface ISystem {

    void startup();
    void teleop(long delta);
    void shutdown();

}
