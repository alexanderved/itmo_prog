package proglab34.places;

import java.util.Objects;

import proglab34.utils.NounWithCases;
import proglab34.interfaces.Runnable;
import proglab34.interfaces.Runner;;

public class HillSlope extends Place implements Runnable {
    private static final NounWithCases HILL_SLOPE_DESCR = new NounWithCases("склон", 
        "склона", "склону", "склон", "склоном", "склоне", "склоны").concat(" холма");

    @Override
    public NounWithCases getDescription() {
        return HILL_SLOPE_DESCR;
    }

    @Override
    public void beRunOnBy(Runner runner) {
        System.out.println(runner.toString()
            + " бросился со " + getDescription().genitive());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof HillSlope)) {
            return false;
        }

        return getDescription().equals(((HillSlope)o).getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString(), getDescription());
    }

    @Override
    public String toString() {
        return getDescription().capitalize().nominative();
    }
}