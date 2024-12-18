package proglab34.entities;

import proglab34.utils.NounWithCases;

import proglab34.interfaces.Bindable;
import proglab34.interfaces.Binding;
import proglab34.interfaces.Bitable;
import proglab34.interfaces.Biter;
import proglab34.interfaces.Chaser;
import proglab34.interfaces.Runner;

import java.util.Objects;

import proglab34.exceptions.AlreadyBound;
import proglab34.exceptions.BiteFailed;
import proglab34.exceptions.NoChaseTarget;
import proglab34.exceptions.NotBound;
import proglab34.exceptions.RunningNotStarted;
import proglab34.exceptions.TooManyChaseTargets;

public class Dog extends Entity implements Chaser, Biter, Bindable {
    private final NounWithCases DOG_DESCR;
    private final int ACCURACY;

    private Runner target;
    private Binding binding;

    public Dog(NounWithCases name, int accuracy) {
        DOG_DESCR = new NounWithCases("пес", "пса",
            "псу", "пса", "псом", "псе", "псы"
        ).concat(" ").concat(name);

        ACCURACY = accuracy;
    }

    @Override
    public NounWithCases getDescription() {
        return DOG_DESCR;
    }

    @Override
    public void startRunning() {
        if (target == null) {
            throw new NoChaseTarget(this);
        }
        super.startRunning();

        System.out.println(getDescription().capitalize().nominative()
            + " начинает преследовать " + target.toString() + ".");
    }

    @Override
    public void stopRunning() {
        super.stopRunning();

        System.out.println(getDescription().capitalize().nominative()
            + " перестает преследовать " + target.toString() + ".");
    }

    @Override
    public void chase(Runner runner) {
        if (target != null) {
            throw new TooManyChaseTargets(this);
        }
        target = runner;
    }

    @Override
    public void unchase() {
        if (target == null) {
            throw new NoChaseTarget(this);
        }

        try {
            stopRunning();
        } catch (RunningNotStarted e) {
            System.out.println(e.getRunner().toString()
                + " отказывается от преследования " + target.toString()
                + ", не начав бежать.");
        }
        target = null;
    }

    @Override
    public int getAttackAccuracy() {
        return ACCURACY;
    }

    @Override
    public void tryBite(Bitable bitable) {
        System.out.println(getDescription().capitalize().nominative()
            + " пытается укусить " + bitable.toString() + ".");

        try {
            bitable.beBittenBy(this);

            System.out.println(getDescription().capitalize().dative()
                + " удается укусить " + bitable.toString() + ".");
        } catch (BiteFailed e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void beBoundWith(Binding binding) {
        if (this.binding != null) {
            throw new AlreadyBound(this);
        }

        this.binding = binding;
    }

    @Override
    public void beUnbound() {
        if (this.binding == null) {
            throw new NotBound(null, this);
        }

        this.binding = null;
    }

    @Override
    public Binding getBinding() {
        return binding;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Dog)) {
            return false;
        }

        Dog other = (Dog)o;

        return getDescription().equals(other.getDescription())
            && getAttackAccuracy() == other.getAttackAccuracy()
            && target.equals(other.target)
            && getBinding().equals(other.getBinding());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), isRunning, ACCURACY,
                            target, binding);
    }

    @Override
    public String toString() {
        return getDescription().capitalize().nominative();
    }
}