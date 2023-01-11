package org.bitbuckets.drive.motor;

import com.revrobotics.*;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.AnalogEncoder;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.lib.ILoggingNode;

public class SparkSwerveModule implements ISwerveModule, ILoggingNode {

    final CANSparkMax driveSpark; //velocity pid
    final CANSparkMax turnSpark; //position pid
    final AnalogEncoder turnAbsoluteEncoder;
    final Rotation2d offset;

    SparkSwerveModule(CANSparkMax driveSpark, CANSparkMax turnSpark, AnalogEncoder turnAbsoluteEncoder, Rotation2d offset) {
        this.driveSpark = driveSpark;
        this.turnSpark = turnSpark;
        this.turnAbsoluteEncoder = turnAbsoluteEncoder;
        this.offset = offset;
    }

    /**
     * Queries the current velocity recorded by the built in hall sensor of the Neo motor
     * 42 counts per rev is the default, the velocity is converted from RPM to M/S by the conversion factor set
     * in the factory method below
     *
     * @return the estimated velocity reported by the encoder
     */
    @Override
    public double queryCurrentVelocityMetersPerSecond() {
        return driveSpark.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42).getVelocity();
    }

    @Override
    public double queryCurrentAngVelocityRadiansPerSecond() {
        return Units.rotationsPerMinuteToRadiansPerSecond(turnEncoder.getVelocity() * DriveConstants.ROTATION_STEP_UP);
    }

    @Override
    public Rotation2d queryCurrentRotation() {

    }

    double cachedVelocity = Double.NaN;

    @Override
    public void commandSetpointValues(double velocitySetpoint_metersPerSecond, Rotation2d turnSetpoint) { //[0, 2pi]
        double angleSetpointRadiansUncompensated = turnSetpoint.getRadians() % DriveConstants.REVOLUTION;


        double angleSetpointRadiansCompensated = Rotation2d.fromRadians(angleSetpointRadiansUncompensated).minus(offset).getRadians();
        turnSpark.getPIDController().setReference(angleSetpointRadiansCompensated, CANSparkMax.ControlType.kPosition);
        double sensorRadiansCompensated = Rotation2d.fromRadians(turnAbsoluteEncoder.get()).minus(offset).getRadians();
        double errorCompensated = angleSetpointRadiansCompensated - sensorRadiansCompensated;


        //handle drive
        double velocity_RPM = velocitySetpoint_metersPerSecond * 60 / DriveConstants.WHEEL_DIAMETER_METERS;

        if (velocity_RPM != cachedVelocity) { cachedVelocity = velocity_RPM;
            driveSpark.getPIDController().setReference(velocity_RPM, CANSparkMax.ControlType.kVelocity);
        }


    }

    @Override
    public void setup(QueueForLoop loop, QueueForLogging logging) {

    }


    //WARNING WARNING WARNING          SHITCODE ALERT           WARNING WARNING WARNING
    public static SparkSwerveModule build(CANSparkMax drive, CANSparkMax turn, AnalogEncoder encoder, Rotation2d offset) {

        drive.enableVoltageCompensation(12);
        drive.setSmartCurrentLimit(80);
        drive.setPeriodicFramePeriod(CANSparkMaxLowLevel.PeriodicFrame.kStatus0, 100); //don't need to report status faults and applied output every half a tick
        drive.setPeriodicFramePeriod(CANSparkMaxLowLevel.PeriodicFrame.kStatus1, 20); //should already be 20
        drive.setPeriodicFramePeriod(CANSparkMaxLowLevel.PeriodicFrame.kStatus2, 20); //should already be 20
        RelativeEncoder driveEncoder = drive.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
        driveEncoder.setPositionConversionFactor(DriveConstants.DRIVE_FACTOR_POS);
        driveEncoder.setVelocityConversionFactor(DriveConstants.DRIVE_FACTOR_VEL);

        SparkMaxAnalogSensor absoluteEncoder = turn.getAnalog(SparkMaxAnalogSensor.Mode.kAbsolute); //has an offset
        absoluteEncoder.setPositionConversionFactor(DriveConstants.TURN_FACTOR_ABS_POS); //needs to scale from volts to radians, so divide cur. voltage by 3.3 (max) to get ratio then multiply by 2pi for radians
        double absoluteAngleUncompensatedRadians = absoluteEncoder.getPosition();
        double absoluteAngleCompensatedRadians = Rotation2d.fromRadians(absoluteAngleUncompensatedRadians).minus(offset).getRadians();
        double absoluteAngleDomainFilteredRadians = absoluteAngleCompensatedRadians % DriveConstants.REVOLUTION;
        //by now this represents the absolute position of our turn

        turn.enableVoltageCompensation(12);
        turn.setSmartCurrentLimit(20);
        turn.setPeriodicFramePeriod(CANSparkMaxLowLevel.PeriodicFrame.kStatus0, 100); //don't need to report status faults and applied output every half a tick
        turn.setPeriodicFramePeriod(CANSparkMaxLowLevel.PeriodicFrame.kStatus1, 20); //should already be 20
        turn.setPeriodicFramePeriod(CANSparkMaxLowLevel.PeriodicFrame.kStatus2, 20); //should already be 20
        RelativeEncoder turnEncoder = turn.getEncoder(SparkMaxRelativeEncoder.Type.kHallSensor, 42);
        turnEncoder.setPositionConversionFactor(DriveConstants.TURN_FACTOR_ABS_POS);
        turnEncoder.setPosition(absoluteAngleDomainFilteredRadians); //now that you, turnEncoder, are in radians, here is our current position, in radians!

        return new SparkSwerveModule(drive, turn, encoder, offset);
    }
}
