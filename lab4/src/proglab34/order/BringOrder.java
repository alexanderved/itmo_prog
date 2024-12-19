package proglab34.order;

import proglab34.interfaces.Bringable;
import proglab34.interfaces.Bringer;
import proglab34.interfaces.Executor;

public class BringOrder extends Order {
    private Bringer bringer;
    private Bringable bringable;

    public BringOrder(Bringer bringer, Bringable bringable) {
        this.bringer = bringer;
        this.bringable = bringable;
    }

    @Override
    public void beExecutedBy(Executor executor) {
        bringer.bring(bringable);
    }
}