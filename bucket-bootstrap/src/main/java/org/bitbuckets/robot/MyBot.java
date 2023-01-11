package org.bitbuckets.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import org.bitbuckets.drive.DriveConstants;
import org.bitbuckets.drive.DriveInput;
import org.bitbuckets.drive.controller.IDriveController;
import org.bitbuckets.drive.controller.RealDriveController;
import org.bitbuckets.drive.controller.module.ISwerveModule;
import org.bitbuckets.drive.controller.module.SparkSwerveModule;
import org.bitbuckets.shared.RobotConstants;

import java.util.Arrays;

/**
 * Acts as the startup location for all of the robot
 */
public class MyBot extends TimedRobot {


    DriveInput cachedInput;
    IDriveController cachedDriveController;


    @Override
    public void robotInit() {

        //TODO PRESET CODE PLEASE FIX
        //TODO if this were fully functional you'd have to register these since they are IProcesses
        ISwerveModule[] modules = new ISwerveModule[] {
                SparkSwerveModule.acquire(
                        new CANSparkMax(0, CANSparkMaxLowLevel.MotorType.kBrushless),
                        new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless),
                        Rotation2d.fromRadians(45)
                ),
                SparkSwerveModule.acquire(
                        new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless),
                        new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless),
                        Rotation2d.fromRadians(90)
                ),
                SparkSwerveModule.acquire(
                        new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless),
                        new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless),
                        Rotation2d.fromRadians(180)
                ),
                SparkSwerveModule.acquire(
                        new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushless),
                        new CANSparkMax(7, CANSparkMaxLowLevel.MotorType.kBrushless),
                        Rotation2d.fromRadians(270)
                ),
        };


        cachedDriveController = new RealDriveController(modules);
        cachedInput = new DriveInput(new Joystick(0));
    }

    @Override
    public void robotPeriodic() {
        ChassisSpeeds desired = new ChassisSpeeds(cachedInput.getInputX(), cachedInput.getInputY(), cachedInput.getInputRot());
        SwerveModuleState[] states = RobotConstants.KINEMATICS.toSwerveModuleStates(desired);
        SwerveModuleState[] optimized = Arrays.stream(states).map(s -> SwerveModuleState.optimize(s, new Rotation2d())).toArray(SwerveModuleState[]::new);
        //TODO robot oriented

        cachedDriveController.doDriveWithStates(optimized);

    }
}
