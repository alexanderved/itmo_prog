package proglab2.pokemons;

import ru.ifmo.se.pokemon.*;
import proglab2.moves.special.*;
import proglab2.moves.status.*;

public class Sunkern extends Pokemon {
    private final static int MIN_LEVEL = 10;

    public Sunkern() {
        this("Санкерн", MIN_LEVEL);
    }

    public Sunkern(String name, int level) {
        this(name, level, MIN_LEVEL);
    }

    protected Sunkern(String name, int level, int min_level) {
        super(name, level);

        if (level < min_level) {
            System.out.println("The given level is too low to perform the required moves");
            System.exit(1);
        }

        setType(Type.GRASS);
        setStats(30.0, 30.0, 30.0, 30.0, 30.0, 30.0);
        setMove(new Confide(), new MegaDrain(), new Swagger());
    }
}