package proglab34.interfaces;

public interface Bindable {
    void beBoundWith(Binding binding);
    void beUnbound();
    Binding getBinding();

    default boolean isBound() {
        return getBinding() != null;
    }
}