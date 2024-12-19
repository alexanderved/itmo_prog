package proglab34.entities;

import proglab34.interfaces.Executor;
import proglab34.order.Order;
import proglab34.interfaces.Bringer;
import proglab34.utils.NounWithCases;

public class Worker extends Person implements Executor, Bringer {
    public Worker(NounWithCases name, int dodgeability) {
        super(name, dodgeability);
    }

    @Override
    public void execute(Order order) {
        System.out.println(getDescription().capitalize().nominative()
            + " со всех ног бросился исполнять приказание.");

        order.beExecutedBy(this);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}