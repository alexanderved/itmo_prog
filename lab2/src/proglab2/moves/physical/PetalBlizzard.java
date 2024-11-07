package proglab2.moves.physical;

import ru.ifmo.se.pokemon.*;

public final class PetalBlizzard extends SpecialMove {
    public PetalBlizzard() {
        super(Type.GRASS, 90.0, 100.0);
    }

    @Override
    protected String describe() {
        return "использует Petal Blizzard";
    }
}
