package org.bitbuckets.lib.component;

//RAII motors, because i'm sick of typing .setVoltageCompensation
public interface MotorFactory {

    Motor makeMotor(int canBusID, boolean brushless, double smartCurrentLimit, int[] statusFramePeriods, double positionConversionFactor, double velocityConversionFactor);

}
