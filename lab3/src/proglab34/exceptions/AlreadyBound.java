package proglab34.exceptions;

import proglab34.interfaces.Bindable;

public class AlreadyBound extends RuntimeException {
    private Bindable bindable;

    public AlreadyBound(Bindable bindable) {
        this.bindable = bindable;
    }

    public Bindable getBindable() {
        return bindable;
    }

    @Override
    public String getMessage() {
        return bindable.toString() + " уже привязан к "
            + bindable.getBinding().toString() + ".";
    }
}