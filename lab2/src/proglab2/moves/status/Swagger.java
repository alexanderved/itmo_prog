package proglab2.moves.status;

import ru.ifmo.se.pokemon.*;

public final class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0.0, 85.0);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.confuse(p);
        p.setMod(Stat.ATTACK, 2);
    }

    @Override
    protected String describe() {
        return "использует Swagger, чтобы вызвать растерянность у противника и " +
            "повысить его Атаку на 2";
    }
}