package proglab34.exceptions;

import proglab34.interfaces.Biter;
import proglab34.interfaces.Bitable;

public class BiteFailed extends Exception {
    private Biter biter;
    private Bitable bitable;

    public BiteFailed(Biter biter, Bitable bitable) {
        this.biter = biter;
        this.bitable = bitable;
    }

    public Biter getBiter() {
        return biter;
    }

    public Bitable getBitale() {
        return bitable;
    }

    @Override
    public String getMessage() {
        return biter.toString() + " не смог укусить " + bitable.toString();
    }
}