package org.bitbuckets.bootstrap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.RobotBase;

public class Main {
    public static void main(String[] args) {
        RobotBase.startRobot(MyBot::new);
    }
}