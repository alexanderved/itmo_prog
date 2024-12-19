package proglab34.interfaces;

import proglab34.order.Order;

public interface Executor {
    default void execute(Order order) {
        order.beExecutedBy(this);
    }
}