package decorator;

/**
 * File: Villain.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Villain class to create Villains for the simulation.  This class extends
 * Concrete Power and will be used to modify Villains and spawn new Villains.
 */
public class Villain extends ConcretePower {

    private String name;
    private int fire;
    private int earth;
    private int wind;
    private int ice;
    private int shock;


    public Villain (String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

}
