package proglab34.places;

import java.util.Arrays;
import java.util.Objects;

import proglab34.utils.FlowerType;
import proglab34.utils.NounWithCases;
import proglab34.interfaces.Runnable;
import proglab34.interfaces.Runner;

public class FlowerGarden extends Place implements Runnable {
    private final NounWithCases FLOWER_GARDEN_DESCR;

    private FlowerType[] flowerTypes;

    public FlowerGarden(Place nearPlace, FlowerType[] flowerTypes) {
        this.flowerTypes = flowerTypes;

        FLOWER_GARDEN_DESCR = new NounWithCases("клумба", "клумбы",
            "клумбе", "клумбу", "клумбой", "клумбе", "клумбы"
        ).concat(" около " + nearPlace.getDescription().genitive());
    }

    @Override
    public NounWithCases getDescription() {
        return FLOWER_GARDEN_DESCR;
    }

    @Override
    public void beRunOnBy(Runner runner) {
        String[] flowers = new String[flowerTypes.length];
        for (int i = 0; i < flowerTypes.length; ++i) {
            flowers[i] = flowerTypes[i].getName().plural();
        }

        System.out.println("Из-под ног " + runner.toString() + " c "
            + getDescription().genitive() + " в разные стороны летят "
            + String.join(", ", flowers) + ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof FlowerGarden)) {
            return false;
        }

        FlowerGarden other = (FlowerGarden)o;

        return getDescription().equals(other.getDescription())
            && Arrays.equals(flowerTypes, other.flowerTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), Arrays.hashCode(flowerTypes));
    }

    @Override
    public String toString() {
        return getDescription().capitalize().nominative();
    }
}