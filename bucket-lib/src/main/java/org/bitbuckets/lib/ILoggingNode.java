package org.bitbuckets.lib;

import java.util.function.Supplier;

public interface ILoggingNode {


    void setup(QueueForLoop loop, QueueForLogging logging);

    class QueueForLoop {

    }

    class QueueForLogging {

        public void registerLog(String key, Supplier<?> suckMyAss) {

        }
    }

}
