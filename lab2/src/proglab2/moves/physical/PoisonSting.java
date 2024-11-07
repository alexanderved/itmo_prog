package proglab2.moves.physical;

import ru.ifmo.se.pokemon.*;

public final class PoisonSting extends SpecialMove {
    private boolean hasPoisoned = false;

    public PoisonSting() {
        super(Type.POISON, 15.0, 100.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.3) {
            Effect.poison(p);
            hasPoisoned = true;
        }
    }

    @Override
    protected String describe() {
        if (hasPoisoned) {
            hasPoisoned = false;
            return "использует Poison Sting и отравляет противника";
        } else {
            return "использует Poison Sting";
        }
    }
}
