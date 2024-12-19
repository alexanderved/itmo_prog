package proglab34.interfaces;

public interface Bringer {
    default void bring(Bringable bringable) {
        bringable.beBroughtBy(this);
    }

    default void unbring(Bringable bringable) {
        bringable.beUnbroughtBy(this);
    }
}