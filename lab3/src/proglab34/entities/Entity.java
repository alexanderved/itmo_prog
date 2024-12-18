package proglab34.entities;

import proglab34.exceptions.AlreadyRunning;
import proglab34.exceptions.RunningNotStarted;
import proglab34.interfaces.Runner;
import proglab34.interfaces.Runnable;
import proglab34.utils.SceneObject;

public abstract class Entity extends SceneObject implements Runner {
    protected boolean isRunning;

    @Override
    public void startRunning() {
        if (isRunning) {
            throw new AlreadyRunning(this);
        }
        isRunning = true;
    }

    @Override
    public void stopRunning() {
        if (!isRunning) {
            throw new RunningNotStarted(this);
        }
        isRunning = false;
    }

    @Override
    public void runOn(Runnable runnable) {
        if (!isRunning) {
            throw new RunningNotStarted(this);
        }

        System.out.println(getDescription().capitalize().nominative()
            + " бежит по " + runnable.toString() + ".");
        
        runnable.beRunOnBy(this);
    }
}