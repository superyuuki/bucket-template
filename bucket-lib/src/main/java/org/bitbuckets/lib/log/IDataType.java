package org.bitbuckets.lib.log;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.SuppliedValueWidget;

import java.util.function.Supplier;

public interface IDataType<T> {

    SuppliedValueWidget<T> ass(String id, Supplier<T> dataType, ShuffleboardContainer container);

}
