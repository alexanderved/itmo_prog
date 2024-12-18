package proglab34.exceptions;

import proglab34.interfaces.Runner;

public class AlreadyRunning extends RuntimeException {
    private Runner runner;

    public AlreadyRunning(Runner runner) {
        this.runner = runner;
    }

    public Runner getRunner() {
        return runner;
    }

    @Override
    public String getMessage() {
        return runner.toString() + " уже бежит.";
    }
}