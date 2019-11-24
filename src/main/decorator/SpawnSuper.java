package decorator;

/**
 * File: SpawnSuper.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Interface class used as foundation for a concrete decorator to
 * spawn heroes and villains.  ConcreteSuper class and abstract class PowerBaseDecorator
 * will implement this Interface class.
 */
public interface SpawnSuper {

    /**
     * Method: Spawns a hero.
     * Inputs: NA
     * Returns: void
     * Description: This method will spawn a hero.  Powers will be given in a separate class.
     */
    public void spawnHero();

    /**
     * Method: Spawns a villain
     * Inputs: NA
     * Returns: void
     * Description: This method will spawn a villain.  Powers will be given in a separate class.
     */
    public void spawnVillain();



}
