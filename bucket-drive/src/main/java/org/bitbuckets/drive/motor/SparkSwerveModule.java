package org.bitbuckets.drive.motor;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.swervedrivespecialties.swervelib.AbsoluteEncoder;
import com.swervedrivespecialties.swervelib.SdsModuleConfigurations;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.lib.ILoggingNode;

public class SparkSwerveModule implements ISwerveModule, ILoggingNode {

    final CANSparkMax driveSpark; //velocity pid
    final CANSparkMax turnSpark; //position pid

    final RelativeEncoder driveEncoder;
    final RelativeEncoder turnEncoder;
    final AbsoluteEncoder turnAbsoluteEncoder;

    public SparkSwerveModule(CANSparkMax driveSpark, CANSparkMax turnSpark, RelativeEncoder driveEncoder, RelativeEncoder turnEncoder, AbsoluteEncoder turnAbsoluteEncoder, PIDController driveControllerVelocity, PIDController turnControllerPosition) {
        this.driveSpark = driveSpark;
        this.turnSpark = turnSpark;
        this.driveEncoder = driveEncoder;
        this.turnEncoder = turnEncoder;
        this.turnAbsoluteEncoder = turnAbsoluteEncoder;
    }

    @Override
    public double queryCurrentVelocityMetersPerSecond() {
        return driveEncoder.getVelocity() * DriveConstants.DRIVE_GEARING / 60.0 * SdsModuleConfigurations.MK4I_L2.getWheelDiameter() * 3.14;

    }

    @Override
    public double queryCurrentAngVelocityRadiansPerSecond() {
        return Units.rotationsPerMinuteToRadiansPerSecond(turnEncoder.getVelocity() * DriveConstants.ROTATION_GEARING);
    }

    @Override
    public Rotation2d queryCurrentRotation() {
        return new Rotation2d(turnAbsoluteEncoder.getAbsoluteAngle());
    }

    double cachedVelocity = Double.NaN;

    @Override
    public void commandSetpointValues(double velocity_metersPerSecond, Rotation2d rotation2d) {

        //meters per minute
        double velocity_RPM = velocity_metersPerSecond * 60 / SdsModuleConfigurations.MK4I_L2.getWheelDiameter();

        //TODO pid controllers with variable delta t

        //drive part with lazy update

        if (velocity_RPM != cachedVelocity) { cachedVelocity = velocity_RPM;


            //m/s mechanism -> rpm motor

            driveSpark.getPIDController().setReference(velocity_RPM, CANSparkMax.ControlType.kVelocity);
        }

        //turn part

    }

    @Override
    public void setup(QueueForLoop loop, QueueForLogging logging) {

    }
}
