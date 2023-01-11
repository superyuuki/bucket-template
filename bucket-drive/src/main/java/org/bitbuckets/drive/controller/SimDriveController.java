package org.bitbuckets.drive.controller;

import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import org.bitbuckets.drive.DriveConstants;

/**
 * Represents a simualted drive controller implementation
 *
 * i nuked this class, this is like less than a quarter of what i had previously
 */
//TODO THIS DOESNT WORK
public class SimDriveController implements IDriveController {

    //TODO flywheel in periodic

    final FlywheelSim[] drive = new FlywheelSim[]{
            //TODO these should probably be the reductions and not the step ups
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_STEP_UP, 0.025),
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_STEP_UP, 0.025),
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_STEP_UP, 0.025),
            new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.DRIVE_STEP_UP, 0.025)
    };
     // i don't actually know why the angular inertial moment is this, i just copied it
    final FlywheelSim[] angular = new FlywheelSim[] { new FlywheelSim(DCMotor.getFalcon500(1), DriveConstants.ROTATION_STEP_UP, 0.004096955) };


    @Override
    public SwerveModulePosition[] queryCurrentStates() {
        return new SwerveModulePosition[0];
    }

    @Override
    public void doDriveWithStates(SwerveModuleState[] states) {

    }



}
