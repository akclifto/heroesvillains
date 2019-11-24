package decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * File: Hero.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Hero classes to create Heroes for the simulation.  This class extends
 * Concrete Power and will be used to modify Heroes and spawn children.
 */
public class Hero extends ConcretePower {

    private String name;
    private int fire;
    private int earth;
    private int wind;
    private int ice;
    private int shock;
    private List<Hero> heroList = new ArrayList<>();


    public Hero (String name) {

        this.name = name;

    }

    public String getName() {
        return name;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setBaseElements() {


    }


}
