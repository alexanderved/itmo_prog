package proglab2.pokemons;

import ru.ifmo.se.pokemon.*;
import proglab2.moves.special.*;
import proglab2.moves.physical.*;

public final class Suicune extends Pokemon {
    private final static int MIN_LEVEL = 10;

    public Suicune() {
        this("Суйкун", MIN_LEVEL);
    }

    public Suicune(String name, int level) {
        this(name, level, MIN_LEVEL);
    }

    protected Suicune(String name, int level, int min_level) {
        super(name, level);

        if (level < min_level) {
            System.out.println("The given level is too low to perform the required moves");
            System.exit(1);
        }

        setType(Type.WATER);
        setStats(100.0, 75.0, 115.0, 90.0, 115.0, 85.0);
        setMove(new Blizzard(), new IceFang(), new Bulldoze(), new Extrasensory());
    }
}