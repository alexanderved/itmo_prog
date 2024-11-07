package proglab2.moves.physical;

import ru.ifmo.se.pokemon.*;

public final class FurySwipes extends PhysicalMove {
    public FurySwipes() {
        super(Type.NORMAL, 18.0, 80.0);
        hits = 3;
    }

    @Override
    protected boolean checkAccuracy(Pokemon att, Pokemon def) {
        return super.checkAccuracy(att, def);
    }

    @Override
    protected String describe() {
        return "использует Fury Swipes";
    }
}