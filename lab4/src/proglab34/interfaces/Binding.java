package proglab34.interfaces;

public interface Binding {
    void beBoundTo(Bindable bindable);
    void beUnboundFrom(Bindable bindable);
    boolean isBoundTo(Bindable bindable);
}