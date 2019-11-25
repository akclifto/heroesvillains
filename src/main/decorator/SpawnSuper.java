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
     * Inputs: name : String
     * Returns: void
     * Description: This method will spawn a hero.  Powers will be given from the parent Hero.
     * createHero will also have a chance to transform a citizen into a hero.
     */
    void createHero(String name);

    /**
     * Method: Spawns a villain
     * Inputs: name : String
     * Returns: void
     * Description: This method will spawn a villain.  Powers will be given in a separate class.
     */
    void spawnVillain(String name);

    /**
     * Method: Transforms a random citizen into Hero.
     * Inputs: NA
     * Returns: void
     * Description: This method will create a new Hero from Random citizens.  This may
     * occur when a new Hero is about to spawn, so a spawnHero method may spawn two
     * heroes.
     */
    boolean randomCitizenHero();



}
