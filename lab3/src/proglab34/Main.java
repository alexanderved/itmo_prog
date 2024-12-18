package proglab34;

import proglab34.interfaces.Binding;
import proglab34.interfaces.Binder;
import proglab34.interfaces.Runnable;
import proglab34.entities.Dog;
import proglab34.entities.Person;
import proglab34.items.Chain;
import proglab34.places.FlowerGarden;
import proglab34.places.House;
import proglab34.places.Place;
import proglab34.utils.FlowerType;
import proglab34.utils.NounWithCases;

public class Main {
    public static void main(String[] args) {
        Person neznaika = new Person(new NounWithCases("Незнайка", "Незнайки",
            "Незнайке", "Незнайку", "Незнайкой", "Незнайке", "Незнайки"), 90);

        Binder fex = new Person(new NounWithCases("Фекс", "Фекса",
            "Фексу", "Фекса", "Фексом", "Фексе", "Фексы"), 60);
        Dog milordik = new Dog(new NounWithCases("Милордик", "Милордика",
            "Милордику", "Милордика", "Милордиком", "Милордике", "Милордики"), 80);
        Binding chain = new Chain();
        fex.bind(chain, milordik);

        Place house = new House();
        Runnable garden = new FlowerGarden(house, new FlowerType[] {
            FlowerType.DAISY, FlowerType.CHAMOMILE, FlowerType.PANSY, FlowerType.TULIP });

        neznaika.startRunning();
        fex.unbind(milordik);
        milordik.chase(neznaika);
        milordik.startRunning();

        System.out.println("");

        neznaika.runOn(garden);
        milordik.runOn(garden);

        System.out.println("");

        milordik.tryBite(neznaika);
    }
}