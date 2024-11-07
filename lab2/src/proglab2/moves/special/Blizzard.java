package proglab2.moves.special;

import ru.ifmo.se.pokemon.*;

public final class Blizzard extends SpecialMove {
    private boolean hasFrozen = false;

    public Blizzard() {
        super(Type.ICE, 110.0, 70.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1) {
            Effect.freeze(p);
            hasFrozen = true;
        }
    }

    @Override
    protected String describe() {
        if (hasFrozen) {
            hasFrozen = false;
            return "использует Blizzard и замораживает противника";
        } else {
            return "использует Blizzard";
        }
    }
}