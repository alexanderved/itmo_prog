package proglab34.places;

import java.util.Arrays;
import java.util.Objects;

import proglab34.utils.BerryType;
import proglab34.utils.NounWithCases;
import proglab34.interfaces.Jumpable;
import proglab34.interfaces.Jumper;
import proglab34.interfaces.Runnable;
import proglab34.interfaces.Runner;

public class BerryGarden extends Place implements Runnable, Jumpable {
    private final NounWithCases BERRY_GARDEN_DESCR;

    private BerryType[] berryTypes;

    public BerryGarden(BerryType[] berryTypes) {
        this.berryTypes = berryTypes;

        BERRY_GARDEN_DESCR = new NounWithCases("грядка", "гредки",
            "грядке", "грядку", "грядкой", "грядке", "грядки"
        );
    }

    @Override
    public NounWithCases getDescription() {
        return BERRY_GARDEN_DESCR;
    }

    private void reactToMovement(Object o) {
        String[] berries = new String[berryTypes.length];
        for (int i = 0; i < berryTypes.length; ++i) {
            berries[i] = berryTypes[i].getName().accusative();
        }

        System.out.println(o.toString() + " топтал "
            + String.join(", ", berries) + ".");
    }

    @Override
    public void beRunOnBy(Runner runner) {
        reactToMovement(runner);
    }

    @Override
    public void beJumpedOnBy(Jumper jumper) {
        reactToMovement(jumper);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BerryGarden)) {
            return false;
        }

        BerryGarden other = (BerryGarden)o;

        return getDescription().equals(other.getDescription())
            && Arrays.equals(berryTypes, other.berryTypes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), Arrays.hashCode(berryTypes));
    }

    @Override
    public String toString() {
        return getDescription().capitalize().nominative();
    }
}