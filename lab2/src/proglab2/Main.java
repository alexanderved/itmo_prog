package proglab2;

import ru.ifmo.se.pokemon.*;
import proglab2.pokemons.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();

        System.out.println((new Nidoqueen()).getHP());
        
        b.addAlly(new Suicune());
        b.addAlly(new Sunkern());
        b.addAlly(new Sunflora());

        b.addFoe(new NidoranF());
        b.addFoe(new Nidorina());
        b.addFoe(new Nidoqueen());

        b.go();       
    }
}