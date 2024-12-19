package proglab34.exceptions;

import proglab34.interfaces.Jumper;

public class AlreadyJumping extends RuntimeException {
    private Jumper jumper;

    public AlreadyJumping(Jumper jumper) {
        this.jumper = jumper;
    }

    public Jumper getJumper() {
        return jumper;
    }

    @Override
    public String getMessage() {
        return jumper.toString() + " уже прыгает.";
    }
}