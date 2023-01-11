package org.bitbuckets.drive;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import org.bitbuckets.shared.RobotConstants;

public interface DriveConstants {

    //TODO divide by 2
    double REVOLUTION = (2.0 * Math.PI);

    double DRIVE_REDUCTION = (14.0 / 50.0) * (27.0 / 17.0) * (15.0 / 45.0); //motor -> axle
    double DRIVE_STEP_UP = 1 / DRIVE_REDUCTION; //axle -> motor

    double ROTATION_REDUCTION = (14.0 / 50.0) * (10.0 / 60.0);
    double ROTATION_STEP_UP = 1 / ROTATION_REDUCTION;

    //motor rotation -> axle rotation -> meters -> circle
    double DRIVE_FACTOR_POS = DRIVE_REDUCTION * RobotConstants.WHEEL_DIAMETER_METERS * Math.PI;
    double DRIVE_FACTOR_VEL = DRIVE_FACTOR_POS / 60.0;

    double TURN_FACTOR_HALL_POS = DRIVE_REDUCTION * REVOLUTION; //give me radians!
    double TURN_FACTOR_HALL_VEL = TURN_FACTOR_HALL_POS / 60; //give me radians / time! or something

    double TURN_FACTOR_ABS_POS = (1/3.3) * REVOLUTION; //give me radians!

    double MAX_DRIVE_VELOCITY = 6380.0 * DRIVE_FACTOR_VEL;
    double SLOW_DRIVE_VELOCITY = MAX_DRIVE_VELOCITY * 0.75;
    double MAX_ANG_VELOCITY = Math.hypot(RobotConstants.WIDTH / 2.0, RobotConstants.BASE / 2.0);

    //TODO get rid of this shit
    SimpleMotorFeedforward FF = new SimpleMotorFeedforward(0.65292, 2.3053, 0.37626); //converts velocity to voltage

    SwerveModuleState[] LOCK = new SwerveModuleState[] {
            new SwerveModuleState(0, Rotation2d.fromDegrees(45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(-45)),
            new SwerveModuleState(0, Rotation2d.fromDegrees(45))
    };



}
