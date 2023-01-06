package org.bitbuckets.lib;

public interface IDataConsumer<DataType> {

    void updateData(DataType object);

}
