package proglab2.moves.physical;

import ru.ifmo.se.pokemon.*;

public final class IceFang extends SpecialMove {
    private boolean hasFrozen = false;
    private boolean hasFlinched = false;

    public IceFang() {
        super(Type.ICE, 65.0, 95.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1) {
            Effect.freeze(p);
            hasFrozen = true;
        }

        if (Math.random() < 0.1) {
            Effect.flinch(p);
            hasFlinched = true;
        }
    }

    @Override
    protected String describe() {
        if (hasFrozen && hasFlinched) {
            hasFrozen = hasFlinched = false;

            return "использует Ice Fang и замораживает противника и вызывает у него страх";
        } else if (hasFrozen) {
            hasFrozen = false;

            return "использует Ice Fang и замораживает противника";
        } else if (hasFlinched) {
            hasFlinched = false;

            return "использует Ice Fang и вызывает у противника страх";
        } else {
            return "использует Ice Fang";
        }
    }
}