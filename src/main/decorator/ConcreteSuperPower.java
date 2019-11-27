package decorator;

import java.util.ArrayList;
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

    private List<Hero> spawnedHeroes = new ArrayList<>();
    private List<Villain> spawnedVillains = new ArrayList<>();

    @Override
    public List<Hero> getSpawnedHeroes() {
        return spawnedHeroes;
    }

    @Override
    public List<Villain> getSpawnedVillains() {
        return spawnedVillains;
    }

    @Override
    public void createHero(String name) {

        if (spawnedHeroes.size() == 0) {
            Hero hero = new Hero(name);
            spawnedHeroes.add(hero);
            System.out.println("The first Hero is born: " + name);
        } else {

            Hero hero = new Hero();
            int rand = ThreadLocalRandom.current().nextInt(0, spawnedHeroes.size());
            Hero temp = spawnedHeroes.get(rand);
            List<Integer> cloneList = absorbPower(temp, null);
            hero.replaceElementList(cloneList);
            hero.setName(name);
            hero.addToHeroList(hero);
            spawnedHeroes.add(hero);
            System.out.println("Another hero is born: " + name + ". Parent: " + temp.getName());
            hero.absorbPower(temp, null);
            System.out.print(temp.getName() + "'s power values: ");
            for (Integer index : temp.getElementList())    {
                System.out.print(index + ", ");
            }
            System.out.println("\n" + name + " inherits her power from " + temp.getName());
            System.out.print(name + "'s power values: ");
            for (Integer index : hero.getElementList())    {
                System.out.print(index + ", ");
            }
            System.out.println();
        }
        //chance to transform normal citizen.
        if (randomCitizenHero()) {
            int tempNum = ThreadLocalRandom.current().nextInt(0, 100);
            Hero newHero = new Hero("Citizen " + tempNum);
            spawnedHeroes.add(newHero);
            System.out.println("A new citizen becomes a Hero! Citizen "
                    + tempNum + " is now a hero!");
        } else {
            System.out.println("The citizens did not heed the call to fight evil.");
        }
    }

    @Override
    public void spawnVillain(String name) {

        if (spawnedVillains.size() == 0) {

            Villain villain = new Villain(name);
            spawnedVillains.add(villain);
            System.out.println("The first Villain has spawned: " + name);
        } else {

            Villain villain = new Villain(name);
            int rand = ThreadLocalRandom.current().nextInt(0, spawnedVillains.size());
            Villain temp = spawnedVillains.get(rand);
            List<Integer> cloneList = absorbPower(null, temp);
            villain.replaceElementList(cloneList);
            spawnedVillains.add(villain);
            System.out.println("A new Villain has spawned: " + name
                    + ", spawned from: " + temp.getName());
            villain.absorbPower(null, temp);
            System.out.print(temp.getName() + "'s power values: ");
            for (Integer index : temp.getElementList())    {
                System.out.print(index + ", ");
            }
            System.out.println("\n" + name + " inherits her power from " + temp.getName());
            System.out.print(name + "'s power values: ");
            for (Integer index : villain.getElementList())    {
                System.out.print(index + ", ");
            }
            System.out.println();

        }

    }

    @Override
    public boolean randomCitizenHero() {

        int[] fib = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        int rand = ThreadLocalRandom.current().nextInt(0, 90);

        for (int i : fib) {
            return i == rand;
        }
        return false;
    }

    @Override
    public void addPower(String name, int eleType, int amountPower) {

        try {
            Hero tempHero = getHero(spawnedHeroes, name);
            Villain tempVillain = getVillain(spawnedVillains, name);

            if (tempHero != null) {
                int element = tempHero.getElementList().get(eleType);
                System.out.println("Element value: " + element);
                System.out.println(amountPower + " was added to " + element);
                element = element + amountPower;
                tempHero.getElementList().set(eleType, element);
            } else if (tempVillain != null) {
                int element = tempVillain.getElementList().get(eleType);
                System.out.println("Element value: " + element);
                System.out.println("new value of " + amountPower
                        + " was added to " + element);
                element = element + amountPower;
                tempVillain.getElementList().set(eleType, element);
            } else {
                System.out.println("Name of hero or villain is not included in lists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Integer> absorbPower(Hero hero, Villain villain) {

        try {
            if (hero == null) {

                return new ArrayList<>(villain.getElementList());

            } else if (villain == null) {

                return new ArrayList<>(hero.getElementList());
            }
        } catch (NullPointerException e) {
            System.out.println("Both hero and villain fields are null.");
            e.printStackTrace();
        }
        return null;
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

        for (Hero hero : list) {
            if (hero.getName().equalsIgnoreCase(name)) {
                System.out.println(name + " was found amongst the heroes.");
                return hero;
            }
        }
        System.out.println("Hero not found in the list.");
        return null;
    }

    @Override
    public Villain getVillain(List<Villain> list, String name) {

        for (Villain villain : list) {
            if (villain.getName().equalsIgnoreCase(name)) {
                System.out.println(name + " was found amongst the villains.");
                return villain;
            }
        }
        System.out.println("Villain not found in the list.");
        return null;
    }

}
