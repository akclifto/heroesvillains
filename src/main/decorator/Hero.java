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

    public Hero(String name) {

        this.name = name;
        setBaseElements(elementList, 0, 11);

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

}
