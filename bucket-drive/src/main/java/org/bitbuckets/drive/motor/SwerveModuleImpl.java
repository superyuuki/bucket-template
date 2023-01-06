package org.bitbuckets.drive.motor;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class SwerveModuleImpl implements ISwerveModule{
    
    final TalonSRX drive;
    final TalonSRX turn;

    SwerveModuleImpl(TalonSRX drive, TalonSRX turn) {
        this.drive = drive;
        this.turn = turn;
    }

    //kinematics goes here
    @Override
    public void setDriveVoltage(double volt) {
        drive.set(TalonSRXControlMode.PercentOutput, volt/12); //please make this less bad
    }

    @Override
    public void setTurnVoltage(double volt) {
        turn.set(TalonSRXControlMode.PercentOutput, volt/12);
    }

    @Override
    public double queryCurrentDriveVoltage() {
        return drive.getMotorOutputVoltage();
    }

    @Override
    public double queryCurrentTurnVoltage() {
        return turn.getMotorOutputVoltage();
    }
}
