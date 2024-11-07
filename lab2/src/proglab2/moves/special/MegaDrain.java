package proglab2.moves.special;

import ru.ifmo.se.pokemon.*;

public final class MegaDrain extends SpecialMove {
    public MegaDrain() {
        super(Type.GRASS, 40.0, 100.0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        int hpDrained = (int)p.getStat(Stat.ATTACK) / 2;
        p.setMod(Stat.HP, -hpDrained);
    }

    @Override
    protected String describe() {
        return "использует Mega Drain и восстанавливает HP";
    }
}