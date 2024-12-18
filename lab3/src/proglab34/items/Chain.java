package proglab34.items;

import java.util.ArrayList;
import java.util.Objects;

import proglab34.exceptions.AlreadyBound;
import proglab34.exceptions.NotBound;
import proglab34.interfaces.Bindable;
import proglab34.interfaces.Binding;
import proglab34.utils.NounWithCases;

public class Chain extends Item implements Binding {
    private static final NounWithCases CHAIN_DESCR = new NounWithCases("цепь", "цепи",
        "цепи", "цепь", "цепью", "цепи", "цепи");

    private ArrayList<Bindable> binded = new ArrayList<Bindable>();

    @Override
    public NounWithCases getDescription() {
        return CHAIN_DESCR;
    }

    @Override
    public void beBoundTo(Bindable bindable) {
        if (isBoundTo(bindable)) {
            throw new AlreadyBound(bindable);
        }

        binded.add(bindable);
    }

    @Override
    public void beUnboundFrom(Bindable bindable) {
        if (!isBoundTo(bindable)) {
            throw new NotBound(this, bindable);
        }

        binded.remove(bindable);
    }

    @Override
    public boolean isBoundTo(Bindable bindable) {
        return binded.contains(bindable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Chain)) {
            return false;
        }

        return this.binded.equals(((Chain)o).binded);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), binded);
    }

    @Override
    public String toString() {
        return getDescription().capitalize().nominative();
    }
}