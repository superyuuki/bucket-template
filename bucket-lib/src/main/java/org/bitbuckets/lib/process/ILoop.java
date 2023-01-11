package org.bitbuckets.lib.process;

public interface ILoop {

    void startup();
    void teleop(long delta);
    void shutdown();

}
