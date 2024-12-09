package proglab34.interfaces;

public interface Dodger {
    int getDodgeability();

    default boolean canDodge(Attacker attacker) {
        return getDodgeability() >= attacker.getAttackAccuracy();
    }
}