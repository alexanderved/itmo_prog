package proglab2.pokemons;

import ru.ifmo.se.pokemon.*;
import proglab2.moves.status.Confide;
import proglab2.moves.physical.PoisonSting;

public class NidoranF extends Pokemon {
    private final static int MIN_LEVEL = 13;

    public NidoranF() {
        this("Нидоран (F)", MIN_LEVEL);
    }

    public NidoranF(String name, int level) {
        this(name, level, MIN_LEVEL);
    }

    protected NidoranF(String name, int level, int min_level) {
        super(name, level);

        if (level < min_level) {
            System.out.println("The given level is too low to perform the required moves");
            System.exit(1);
        }

        setType(Type.POISON);
        setStats(55.0, 47.0, 52.0, 40.0, 40.0, 41.0);
        setMove(new PoisonSting(), new Confide());
    }
}