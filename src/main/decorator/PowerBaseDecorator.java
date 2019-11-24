package decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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


    private Hero hero;
    private Villain villain;
    private List<Hero> spawnedHeroes = new ArrayList<>();
    private List<Villain> spawnedVillains = new ArrayList<>();
    private static int citizenHero = 0;

    @Override
    public void spawnHero(String name) {

        this.hero = new Hero (name);
        spawnedHeroes.add(this.hero);
        System.out.println("A new Hero is born: " + name);
        System.out.println(name + " does not have any special powers yet!");
        if (randomCitizenHero()) {
            System.out.println("A new citizen becomes a Hero! Citizen "
                    + citizenHero + "is now a hero!");
        }
    }

    @Override
    public void spawnVillain(String name) {

    }

    /**
     * Method: Transforms a random citizen into Hero.
     * Inputs: NA
     * Returns: void
     * Description: This method will create a new Hero from Random citizens.  This may
     * occur when a new Hero is about to spawn, so a spawnHero method may spawn two
     * heroes.
     */
    public boolean randomCitizenHero() {

        int[] fib = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        int rand = ThreadLocalRandom.current().nextInt(0, 143);

        for (int i : fib) {
            return i == rand;
        }
        return false;
    }

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
    public abstract void absorbPower();

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
