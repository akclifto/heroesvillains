package decorator;

import java.util.List;


/**
 * File: PowerBaseDecorator.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Abstract class used as foundation for ConcretePower class.  This class
 * implements SpawnSuper and can spawn heroes and villains with varied powers.  ConcretePower
 * will inherit its methods to further build Hero and Villain classes.
 */
public abstract class PowerBaseDecorator implements SpawnSuper {

    /**Passing spawnHero from interface class. */
    public abstract void createHero(String name);

    /**Passing spawnVillain from interface class. */
    public abstract void spawnVillain(String name);

    /**Passing randomCitizenHero from interface class. */
    public abstract boolean randomCitizenHero();

    /**Gets a list of all spawned Heroes. */
    public abstract List<Hero> getSpawnedHeroes();

    /**Gets a list of all spawned Villains. */
    public abstract List<Villain> getSpawnedVillains();

    /**
     * Method: Add powers to hero or villain by name;
     * Inputs: name : String, powerType : int, amountPower : int
     * Returns: void
     * Description: This method will set a power type to a hero or villain by name,
     * powertype and amount of power.
     */
    public abstract void addPower(String name, int eleType, int amountPower);

    /**
     * Method: Absorb the power of another hero or villain.
     * Inputs: NA
     * Returns: void
     * Description: This method allow a hero or villain to absorb the power of
     * another hero or villain.  This will be used also to spawn children from both
     * villains and heroes.
     */
    public abstract List<Integer> absorbPower(Hero hero, Villain villian);

    /**
     * Method: Sets base elements for Heroes and Villains.
     * Inputs: list : List, min : int, max : int
     * Returns: void
     * Description: This method will set base attirbutes for both Heroes and Villains
     * and allows the user to set custom min, max options for both.
     */
    public abstract void setBaseElements(List<Integer> list, int min, int max);

    /**
     * Method: Find selected hero in a list.
     * Inputs: list : List
     * Returns: Hero
     * Description: This method will search through the list of created
     * Hero to find a hero by their name.
     */
    public abstract Hero getHero(List<Hero> list, String name);

    /**
     * Method: Find selected villain in a list.
     * Inputs: list : List
     * Returns: Villain
     * Description: This method will search through the list of created
     * villains to find a hero by their name.
     */
    public abstract Villain getVillain(List<Villain> list, String name);

}
