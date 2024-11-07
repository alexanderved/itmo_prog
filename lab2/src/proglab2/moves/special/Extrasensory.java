package proglab2.moves.special;

import ru.ifmo.se.pokemon.*;

public final class Extrasensory extends SpecialMove {
    private boolean hasFlinched = false;

    public Extrasensory() {
        super(Type.PSYCHIC, 80.0, 100.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        if (Math.random() < 0.1) {
            Effect.flinch(p);
            hasFlinched = true;
        }
    }

    @Override
    protected String describe() {
        if (hasFlinched) {
            hasFlinched = false;
            return "использует Extrasensory и вызывает у противника страх";
        } else {
            return "использует Extrasensory";
        }
    }
}