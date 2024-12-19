package proglab34.entities;

import proglab34.utils.NounWithCases;
import proglab34.utils.SceneObject;
import proglab34.interfaces.Attacker;
import proglab34.interfaces.Bindable;
import proglab34.interfaces.Binder;
import proglab34.interfaces.Binding;
import proglab34.interfaces.Bitable;
import proglab34.interfaces.Biter;
import proglab34.interfaces.Dodger;

import proglab34.exceptions.AlreadyBound;
import proglab34.exceptions.BiteFailed;
import proglab34.exceptions.NotBound;

import java.util.Objects;

public class Person extends Entity implements Dodger, Bitable, Binder {
    public class Hands extends SceneObject implements Bindable {
        private final NounWithCases HANDS_DESCR = new NounWithCases("руки", "рук",
            "рукам", "руки", "руками", "руках", "руки")
            .concat(" ").concat(Person.this.getDescription().genitive());
        private Binding binding;

        @Override
        public NounWithCases getDescription() {
            return HANDS_DESCR;
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

            if (!(o instanceof Hands)) {
                return false;
            }

            Hands other = (Hands)o;

            return getDescription().equals(other.getDescription())
                && getBinding().equals(other.getBinding());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getDescription(), getBinding());
        }

        @Override
        public String toString() {
            return getDescription().capitalize().nominative();
        }
    }

    private final NounWithCases PERSON_DESCR;
    private final int DODGEABILITY;
    private final Hands HANDS;

    public Person(NounWithCases name, int dodgeability) {
        PERSON_DESCR = new NounWithCases("коротышка", "коротышки",
            "коротышке", "коротышку", "коротышкой", "коротышке", "коротышки"
        ).concat(" ").concat(name);

        DODGEABILITY = dodgeability;
        HANDS = new Hands();
    }

    public Hands getHands() {
        return HANDS;
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
        stopJumping();
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