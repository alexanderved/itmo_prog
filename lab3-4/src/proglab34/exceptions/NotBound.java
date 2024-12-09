package proglab34.exceptions;

import proglab34.interfaces.Binding;
import proglab34.interfaces.Bindable;

public class NotBound extends RuntimeException {
    private Binding binding;
    private Bindable bindable;

    public NotBound(Binding binding, Bindable bindable) {
        this.binding = binding;
        this.bindable = bindable;
    }

    public Binding getBinding() {
        return binding;
    }

    public Bindable getBindable() {
        return bindable;
    }

    @Override
    public String getMessage() {
        if (binding == null) {
            return bindable.toString() + " ни к чему не привязан.";
        } else if (bindable == null) {
            return binding.toString() + " ни к чему не привязан.";
        } else {
            return binding.toString() + " и " + bindable.toString() + " не связаны.";
        }
    }
}