package proglab2.pokemons;

import proglab2.moves.status.Confide;

public final class Nidoqueen extends Nidorina {
    private final static int MIN_LEVEL = 1;

    public Nidoqueen() {
        this("Нидоквин", MIN_LEVEL);
    }

    public Nidoqueen(String name, int level) {
        this(name, level, MIN_LEVEL);
    }

    protected Nidoqueen(String name, int level, int min_level) {
        super(name, level, min_level);

        setStats(90.0, 92.0, 87.0, 75.0, 85.0, 76.0);
        addMove(new Confide());
    }
}