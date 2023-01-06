package org.bitbuckets.lib;

//runs after ilogic
public interface ISimSystem {

    void startup();
    void teleop(long delta);
    void shutdown();

}
