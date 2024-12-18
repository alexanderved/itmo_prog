package proglab34.interfaces;

public interface Binder {
    default void bind(Binding binding, Bindable bindable) {
        binding.beBoundTo(bindable);
        bindable.beBoundWith(binding);
    }

    default void unbind(Bindable bindable) {
        bindable.getBinding().beUnboundFrom(bindable);
        bindable.beUnbound();
    }
}