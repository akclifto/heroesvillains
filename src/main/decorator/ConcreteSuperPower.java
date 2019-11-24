package decorator;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * File: ConcretePower.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Class extends PowerBaseDecorator and will be used to add powers to
 * heroes and villains.  This class will be extended by the Hero and Villain classes.
 */
public class ConcreteSuperPower extends PowerBaseDecorator {

    @Override
    public void addPower(String name, int eleType, int amountPower) {




    }

    @Override
    public void absorbPower() {
        //TODO
    }


    @Override
    public void setBaseElements(List<Integer> list, int min, int max) {

        try {
            for (int i = 0; i < list.size(); i++) {
                int rand = ThreadLocalRandom.current().nextInt(min, max);
                list.set(i, rand);
            }
        } catch (NullPointerException e) {
            System.out.println("Element list is pointing to null.");
            e.printStackTrace();
        }
    }


    @Override
    public Hero getHero(List<Hero> list, String name) {

        for (Hero item : list) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            } else {
                System.out.println("Hero not found in the list.");
            }
        }
        return null;
    }

    @Override
    public Villain getVillain(List<Villain> list, String name) {

        for (Villain item : list) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            } else {
                System.out.println("Villain not found in the list.");
            }
        }
        return null;
    }




}
