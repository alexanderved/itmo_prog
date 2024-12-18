package proglab34.places;

import java.util.Objects;

import proglab34.utils.NounWithCases;

public class House extends Place {
    private static final NounWithCases HOUSE_DESCR = new NounWithCases("дом", "дома",
        "дому", "дом", "домом", "доме", "дома");

    @Override
    public NounWithCases getDescription() {
        return HOUSE_DESCR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof House)) {
            return false;
        }

        return getDescription().equals(((House)o).getDescription());
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