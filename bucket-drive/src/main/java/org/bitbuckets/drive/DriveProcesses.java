package org.bitbuckets.drive;

import org.bitbuckets.lib.process.IProcess;

import static org.bitbuckets.lib.process.IProcess.CORE;

public interface DriveProcesses {

    IProcess.ProcessId DRIVE = CORE.child("drive");
    IProcess.ProcessId SPARK_CONTROLLER = DRIVE.child("spark-controller");

}
