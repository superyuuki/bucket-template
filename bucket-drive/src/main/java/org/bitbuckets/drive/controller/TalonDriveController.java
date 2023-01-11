package org.bitbuckets.drive.controller;

/*
public class TalonDriveController implements IDriveController {

    final SwerveModule[] swerve;

    public TalonDriveController(SwerveModule[] swerve) {
        this.swerve = swerve;
    }

    public SwerveModuleState[] queryCurrentStates() {
        SwerveModuleState[] states = new SwerveModuleState[4];

        for (int i = 0; i < swerve.length; i++) {
            SwerveModule module = swerve[i];

            states[i] = new SwerveModuleState(module.getDriveVelocity(), new Rotation2d(module.getSteerAngle()));
        }

        return states;
    }

    public void doDriveWithStates(SwerveModuleState[] states) {

        for(int i = 0; i < swerve.length; i++)
        {
            double voltage = MathUtil.clamp(DriveConstants.FF.calculate(states[i].speedMetersPerSecond), -12, 12);
            double radians = states[i].angle.getRadians();

            swerve[i].set(voltage, radians);
        }

    }



}
*/
