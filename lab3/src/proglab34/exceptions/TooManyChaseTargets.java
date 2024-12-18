package proglab34.exceptions;

import proglab34.interfaces.Chaser;

public class TooManyChaseTargets extends RuntimeException {
    private Chaser chaser;

    public TooManyChaseTargets(Chaser chaser) {
        this.chaser = chaser;
    }

    public Chaser getChaser() {
        return chaser;
    }

    @Override
    public String getMessage() {
        return chaser.toString() + " не может одновременно преследовать несколько целей.";
    }
}