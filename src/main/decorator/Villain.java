package decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private List<Hero> villainList = new ArrayList<>();


    public Villain (String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public List<Hero> getVillainList() {
        return villainList;
    }

    public List<Integer> getElementList() {

        return elementList;
    }

    public void replaceElementList(List<Integer> list) {

        this.elementList = list;

    }

}
