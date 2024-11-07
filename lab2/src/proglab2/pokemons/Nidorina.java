package proglab2.pokemons;

import proglab2.moves.physical.FurySwipes;

public class Nidorina extends NidoranF {
    private final static int MIN_LEVEL = 20;

    public Nidorina() {
        this("Нидорина", MIN_LEVEL);
    }

    public Nidorina(String name, int level) {
        this(name, level, MIN_LEVEL);
    }

    protected Nidorina(String name, int level, int min_level) {
        super(name, level, min_level);

        setStats(70.0, 62.0, 67.0, 55.0, 55.0, 56.0);
        addMove(new FurySwipes());
    }
}