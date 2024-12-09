package proglab34.exceptions;

import proglab34.interfaces.Runner;

public class RunningNotStarted extends RuntimeException {
    private Runner runner;

    public RunningNotStarted(Runner runner) {
        this.runner = runner;
    }

    public Runner getRunner() {
        return runner;
    }

    @Override
    public String getMessage() {
        return runner.toString() + " еще не начал бежать.";
    }
}