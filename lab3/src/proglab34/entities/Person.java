package proglab34.entities;

import proglab34.utils.NounWithCases;

import proglab34.interfaces.Attacker;
import proglab34.interfaces.Bindable;
import proglab34.interfaces.Binder;
import proglab34.interfaces.Binding;
import proglab34.interfaces.Bitable;
import proglab34.interfaces.Biter;
import proglab34.interfaces.Dodger;

import java.util.Objects;

import proglab34.exceptions.BiteFailed;

public class Person extends Entity implements Dodger, Bitable, Binder {
    private final NounWithCases PERSON_DESCR;
    private final int DODGEABILITY;

    public Person(NounWithCases name, int dodgeability) {
        PERSON_DESCR = new NounWithCases("коротышка", "коротышки",
            "коротышке", "коротышку", "коротышкой", "коротышке", "коротышки"
        ).concat(" ").concat(name);

        DODGEABILITY = dodgeability;
    }

    @Override
    public NounWithCases getDescription() {
        return PERSON_DESCR;
    }

    @Override
    public void startRunning() {
        super.startRunning();

        System.out.println(getDescription().capitalize().nominative()
            + " начинает бежать со всех ног.");
    }

    @Override
    public void stopRunning() {
        super.stopRunning();

        System.out.println(getDescription().capitalize().nominative()
            + " останавливается.");
    }

    @Override
    public int getDodgeability() {
        return DODGEABILITY;
    }

    @Override
    public boolean canDodge(Attacker attacker) {
        return isRunning ? Dodger.super.canDodge(attacker) : false;
    }

    @Override
    public void beBittenBy(Biter biter) throws BiteFailed {
        if (canDodge(biter)) {
            System.out.println(getDescription().capitalize().nominative()
                + " уклоняется от укуса " + biter.toString() + ".");

            throw new BiteFailed(biter, this);
        }

        System.out.println(getDescription().capitalize().dative()
            + " не удается уклониться от укуса " + biter.toString() + ".");

        stopRunning();
    }

    @Override
    public void bind(Binding binding, Bindable bindable) {
        Binder.super.bind(binding, bindable);

        /* System.out.println(getDescription().capitalize().nominative() + " привязывает "
            + binding.toString() + " к " + bindable.toString() + "."); */
    }

    @Override
    public void unbind(Bindable bindable) {
        System.out.println(getDescription().capitalize().nominative() + " отвязывает "
            + bindable.getBinding().toString() + " от " + bindable.toString() + ".");
            
        Binder.super.unbind(bindable);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person other = (Person)o;

        return getDescription().equals(other.getDescription())
            && getDodgeability() == other.getDodgeability();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), isRunning, DODGEABILITY);
    }

    @Override
    public String toString() {
        return getDescription().capitalize().nominative();
    }
}