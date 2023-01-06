package org.bitbuckets.lib;

import java.util.ArrayDeque;
import java.util.Queue;

public abstract class IKernel<T> implements ISystem {

    final Queue<T> queue = new ArrayDeque<>();

    final T defaultState;
    T lastState;

    public IKernel() {
        this.defaultState = defaultState();
        this.lastState = this.defaultState;
    }

    protected abstract T defaultState();

    protected abstract void teleopWithState(T lastState, T commandState);
    protected abstract void startupWithState();
    protected abstract void shutdownWithState();

    ///     implementations ///

    @Override
    public final void startup() {
        this.startupWithState();
    }

    @Override
    public final void teleop(long delta) {
        T command = queue.poll();
        T trueCommand = command == null ? defaultState : command;

        teleopWithState(lastState, trueCommand);

        lastState = trueCommand;
    }

    @Override
    public final void shutdown() {
        shutdownWithState();
    }

    //public facing
    public void queue(T command) {
        queue.add(command);
    }
}
