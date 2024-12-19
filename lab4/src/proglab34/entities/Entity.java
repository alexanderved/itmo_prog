package proglab34.entities;

import proglab34.exceptions.AlreadyJumping;
import proglab34.exceptions.AlreadyRunning;
import proglab34.exceptions.JumpingNotStarted;
import proglab34.exceptions.RunningNotStarted;
import proglab34.interfaces.Runner;
import proglab34.interfaces.Jumpable;
import proglab34.interfaces.Jumper;
import proglab34.interfaces.Runnable;
import proglab34.utils.SceneObject;

public abstract class Entity extends SceneObject implements Runner, Jumper {
    protected boolean isRunning;
    protected boolean isJumping;

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

    @Override
    public void startJumping() {
        if (isJumping) {
            throw new AlreadyJumping(this);
        }
        isJumping = true;
    }

    @Override
    public void stopJumping() {
        if (!isJumping) {
            throw new JumpingNotStarted(this);
        }
        isJumping = false;
    }

    @Override
    public void jumpOn(Jumpable jumpable) {
        if (!isJumping) {
            throw new JumpingNotStarted(this);
        }

        System.out.println(getDescription().capitalize().nominative()
            + " запрыгал по " + jumpable.toString() + ".");
        
        jumpable.beJumpedOnBy(this);
    }
}