package decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * File: Villain.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Villain class to create Villains for the simulation.  This class extends
 * Concrete Power and will be used to modify Villains and spawn new Villains.
 */
public class Villain extends ConcreteSuperPower {

    private String name;
    private int fire = 0;
    private int earth = 0;
    private int wind = 0;
    private int ice = 0;
    private int shock = 0;
    private List<Integer> elementList = Arrays.asList(fire, earth, wind, ice, shock);


    /**
     * Method: Constructor method
     * Inputs: name : String
     * Returns: NA
     * Description: Constructor to set the name and base elements of a villain.
     */
    public Villain(String name) {

        this.name = name;
        int maxBound = ThreadLocalRandom.current().nextInt(2, 11);
        setBaseElements(elementList, 0, maxBound);


    }

    public String getName() {
        return name;
    }

    public List<Integer> getElementList() {

        return elementList;
    }

    /**
     * Method: Replaces element list of a villain.
     * Inputs: list : List
     * Returns: void
     * Description: This method will replace the list of an existing villain's current
     * list.  It is used when a new villain spawns, cloning the powers of its parents.
     */
    public void replaceElementList(List<Integer> list) {

        this.elementList = list;

    }



}
