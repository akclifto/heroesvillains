package decorator;

/**
 * File: PowerBaseDecorator.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Abstract class used as foundation for ConcretePower class.  This class
 * implements SpawnSuper and can spawn heroes and villains with varied powers.  ConcretePower
 * will inherit its methods to further build Hero and Villain classes.
 */
public abstract  class PowerBaseDecorator implements SpawnSuper {

    @Override
    public void spawnHero() {

    }

    @Override
    public void spawnVillain() {

    }

    /**
     * Method: Add powers to hero or villain by name;
     * Inputs: name : String, powerType : int, amountPower : int
     * Returns: void
     * Description: This method will set a power type to a hero or villain by name,
     * powertype and amount of power.
     */
    public abstract void addPower(String name, int powerType, int amountPower);

    /**
     * Method: Absorb the power of another hero or villain.
     * Inputs: NA
     * Returns: void
     * Description: This method allow a hero or villain to absorb the power of
     * another hero or villain.  This will be used also to spawn children from both
     * villains and heroes.
     */
    public abstract void absorbPower();
}
