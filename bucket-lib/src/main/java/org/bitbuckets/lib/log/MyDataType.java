package org.bitbuckets.lib.log;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardContainer;
import edu.wpi.first.wpilibj.shuffleboard.SuppliedValueWidget;
import edu.wpi.first.wpilibj.shuffleboard.WidgetType;

import java.util.function.Supplier;

public class MyDataType implements IDataType<String> {


    @Override
    public SuppliedValueWidget<String> ass(String id, Supplier<String> dataType, ShuffleboardContainer container) {
        return container.addString(id,dataType).withWidget(BuiltInWidgets.kTextView);
    }
}
