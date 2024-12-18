package proglab34.exceptions;

import proglab34.interfaces.Chaser;

public class NoChaseTarget extends RuntimeException {
    private Chaser chaser;

    public NoChaseTarget(Chaser chaser) {
        this.chaser = chaser;
    }

    public Chaser getChaser() {
        return chaser;
    }

    @Override
    public String getMessage() {
        return chaser.toString() + " не имеет цели для преследования.";
    }
}