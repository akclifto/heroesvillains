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

    private Hero hero;
    private Villain villain;
    private List<Hero> spawnedHeroes = new ArrayList<>();
    private List<Villain> spawnedVillains = new ArrayList<>();
    private static int citizenHero = 0;

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
            this.hero = new Hero(name);
            spawnedHeroes.add(this.hero);
            System.out.println("The first Hero is born: " + name);
        } else {
            this.hero = new Hero();
            int rand = ThreadLocalRandom.current().nextInt(0, spawnedHeroes.size() - 1);
            Hero temp = spawnedHeroes.get(rand);
            hero = temp;
            hero.setName(name);
        }

        // chance to transform citizen to hero.
        if (randomCitizenHero()) {
            Hero newHero = new Hero("Citizen " + citizenHero);
            spawnedHeroes.add(newHero);
            System.out.println("A new citizen becomes a Hero! Citizen "
                    + citizenHero + "is now a hero!");
            citizenHero++;
        } else {
            System.out.println("The citizens did not heed the call to fight evil.");
        }
    }

    @Override
    public void spawnVillain(String name) {

        this.villain = new Villain(name);
        spawnedVillains.add(villain);
        System.out.println("A new Villain has spawned: " + name);

    }

    @Override
    public boolean randomCitizenHero() {

        int[] fib = {0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        int rand = ThreadLocalRandom.current().nextInt(0, 143);

        for (int i : fib) {
            return i == rand;
        }
        return false;
    }

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
