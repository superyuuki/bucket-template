package org.bitbuckets.odometry;

import org.bitbuckets.lib.process.IProcess;

public interface OdometryProcesses {

    IProcess.ProcessId ODOMETRY = IProcess.CORE.child("odometry");

}
