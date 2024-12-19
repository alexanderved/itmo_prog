package proglab34.order;

import proglab34.interfaces.Executor;

public abstract class Order {
    public abstract void beExecutedBy(Executor executor);
}