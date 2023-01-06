package org.bitbuckets.drive.controller;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.drive.IDriveController;

public class DriveControllerSim implements IDriveController {

    //TODO flywheel in periodic

    final FlywheelSim[] drive = new FlywheelSim[]{
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_GEARING, 0.025),
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_GEARING, 0.025),
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_GEARING, 0.025),
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_GEARING, 0.025)
    };
     // i don't actually know why the angular inertial moment is this, i just copied it
    final FlywheelSim[] angular = new FlywheelSim[] { new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.ROTATION_GEARING, 0.004096955) };

    @Override
    public SwerveModuleState[] queryCurrentStates() {


        drive[0].setInputVoltage();

        for (int i = 0; i < drive.length; i++) {

            SwerveModuleState state = new SwerveModuleState();

            double deltadeg = Math.toDegrees(drive[i].getAngularVelocityRadPerSec() * 7);


        }

        return new SwerveModuleState[0];
    }

    @Override
    public void doDriveWithStates(SwerveModuleState[] states) {

    }



}
