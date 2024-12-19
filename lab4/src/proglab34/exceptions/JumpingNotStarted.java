package proglab34.exceptions;

import proglab34.interfaces.Jumper;

public class JumpingNotStarted extends RuntimeException {
    private Jumper jumper;

    public JumpingNotStarted(Jumper jumper) {
        this.jumper = jumper;
    }

    public Jumper getJumper() {
        return jumper;
    }

    @Override
    public String getMessage() {
        return jumper.toString() + " еще не начал прыгать.";
    }
}