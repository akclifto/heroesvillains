package decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
    private int fire = 0;
    private int earth = 0;
    private int wind = 0;
    private int ice = 0;
    private int shock = 0;
    private List<Integer> elementList = new ArrayList<>();
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

        try {
            for (int i = 0; i < elementList.size(); i++) {
                int rand = ThreadLocalRandom.current().nextInt(0, 11);
                elementList.set(i, rand);
            }
        } catch (NullPointerException e) {
            System.out.println("Element list is pointing to null.");
            e.printStackTrace();
        }
    }

}
