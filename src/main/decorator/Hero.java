package decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * File: Hero.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Hero classes to create Heroes for the simulation.  This class extends
 * Concrete Power and will be used to modify Heroes and spawn children.
 */
public class Hero extends ConcreteSuperPower {

    private String name;
    private int fire = 0;
    private int earth = 0;
    private int wind = 0;
    private int ice = 0;
    private int shock = 0;
    private List<Integer> elementList = Arrays.asList(fire, earth, wind, ice, shock);
    private List<Hero> heroList = new ArrayList<>();


    public Hero() {
        //ctor for all born heroes other than the first.
    }

    /**
     * Method: Constructor method
     * Inputs: name : String
     * Returns: NA
     * Description: Constructor to set the name and base elements of a hero.
     */
    public Hero(String name) {

        this.name = name;
        setBaseElements(elementList, 0, 11);
        heroList.add(this);

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public List<Integer> getElementList() {

        return elementList;
    }

    /**
     * Method: Replaces element list of a hero.
     * Inputs: list : List
     * Returns: void
     * Description: This method will replace the list of an existing hero's current
     * list.  It is used when a new hero is born, cloning the powers of its parents.
     */
    public void replaceElementList(List<Integer> list) {

        this.elementList = list;

    }
}
