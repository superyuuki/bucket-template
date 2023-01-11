package org.bitbuckets.lib.process;

import edu.wpi.first.util.sendable.Sendable;

import java.util.function.Supplier;

/**
 * Interface that should be implemented on every key process. Provides access to a myriad
 * of key utilities such as scheduled loop support and nested, clean logging.
 *
 * NOTE data transfer is handled by a different utility
 *
 * If something is a behavior that should always happen no matter what the user is doing, use an iprocess
 * if something is dependent on game phase, etc, it's probably best to be in a
 */
public interface IProcess {

    ProcessId setup(ProcessSetup processSetup);

    ProcessId CORE = new ProcessId();

    class ProcessId {
        //TODO kernels, loggers, whatever

        String[] path;

        ProcessId() {

        }

        public ProcessId child(String id) {
            return new ProcessId();
        }
    }

    /**
     * represents all the functions a IKernel can do
     */
    class ProcessSetup {

        public void registerInit(Runnable runnable) {

        }

        public void registerShutdown(Runnable runnable) {

        }

        public void registerLoop(Runnable runnable) {

        }

        public void registerLogging(String id, Supplier<Object> smartLog) {

        }

        public void registerLogging(String id, Sendable sendable) {

        }

    }

}
