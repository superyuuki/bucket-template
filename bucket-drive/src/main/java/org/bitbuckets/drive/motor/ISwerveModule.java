package org.bitbuckets.drive.motor;

public interface ISwerveModule {

    void setDriveVoltage(double volt);
    void setTurnVoltage(double volt);

    double queryCurrentDriveVoltage();
    double queryCurrentTurnVoltage();

}
