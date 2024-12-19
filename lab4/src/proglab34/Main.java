package proglab34;

import proglab34.interfaces.Binding;
import proglab34.entities.Dog;
import proglab34.entities.Person;
import proglab34.entities.Worker;
import proglab34.items.Chain;
import proglab34.order.BringOrder;
import proglab34.places.BerryGarden;
import proglab34.places.FlowerGarden;
import proglab34.places.HillSlope;
import proglab34.places.House;
import proglab34.places.Place;
import proglab34.utils.BerryType;
import proglab34.utils.FlowerType;
import proglab34.utils.NounWithCases;

public class Main {
    public static void main(String[] args) {
        // Создание объектов
        Person neznaika = new Person(new NounWithCases("Незнайка", "Незнайки",
            "Незнайке", "Незнайку", "Незнайкой", "Незнайке", "Незнайки"), 90);

        Worker fex = new Worker(new NounWithCases("Фекс", "Фекса",
            "Фексу", "Фекса", "Фексом", "Фексе", "Фексы"), 61);
        Worker fix = new Worker(new NounWithCases("Фикс", "Фикса",
            "Фиксу", "Фикса", "Фиксом", "Фикси", "Фиксы"), 60);

        Dog milordik = new Dog(new NounWithCases("Милордик", "Милордика",
            "Милордику", "Милордика", "Милордиком", "Милордике", "Милордики"), 80,
            new String[]{"большой", "кудлатый"});
        Dog cesarino = new Dog(new NounWithCases("Цезарино"), 85,
            new String[]{"бесхвостый", "поджарый",
                         "с длинными худыми костистыми лапами",
                         "с короткой коричневой шерстью"});

        Place house = new House();
        FlowerGarden garden = new FlowerGarden(house, new FlowerType[] {
            FlowerType.DAISY, FlowerType.CHAMOMILE, FlowerType.PANSY, FlowerType.TULIP });
        HillSlope hillSlope = new HillSlope();
        BerryGarden berryGarden = new BerryGarden(new BerryType[]{BerryType.STRAWBERRY});

        Binding chain = new Chain();
        Binding dogChain = new Chain();


        // Задание начальных условий
        neznaika.getHands().beBoundWith(chain);
        chain.beBoundTo(neznaika.getHands());
        
        fex.bind(dogChain, milordik);


        // Выполнение
        fex.execute(new BringOrder(fex, milordik));
        fix.unbind(neznaika.getHands());

        System.out.println("");

        neznaika.startRunning();
        fex.unbind(milordik);
        milordik.chase(neznaika);
        milordik.startRunning();

        System.out.println("");

        neznaika.runOn(garden);
        milordik.runOn(garden);

        milordik.tryBite(neznaika);

        System.out.println("");

        fex.bring(cesarino);
        cesarino.chase(neznaika);
        cesarino.startRunning();

        neznaika.runOn(hillSlope);
        neznaika.startJumping();
        neznaika.jumpOn(berryGarden);

        milordik.runOn(berryGarden);
        cesarino.runOn(berryGarden);
    }
}