package proglab2.pokemons;

import proglab2.moves.physical.PetalBlizzard;

public final class Sunflora extends Sunkern {
    private final static int MIN_LEVEL = 50;

    public Sunflora() {
        this("Санфлора", MIN_LEVEL);
    }

    public Sunflora(String name, int level) {
        this(name, level, MIN_LEVEL);
    }

    protected Sunflora(String name, int level, int min_level) {
        super(name, level, min_level);

        setStats(75.0, 75.0, 55.0, 105.0, 85.0, 30.0);
        addMove(new PetalBlizzard());
    }
}