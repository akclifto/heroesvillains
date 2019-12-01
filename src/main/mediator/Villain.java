package mediator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * File: Villain.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: This class will hold the Villains that do battle with
 * the Heroes.  Communication will run through the mediator.
 */
public class Villain extends CombatBase {

    private String name;
    private int fire = 0;
    private int earth = 0;
    private int wind = 0;
    private int ice = 0;
    private int shock = 0;
    private int health;
    private int strength;
    private boolean resting = false;
    private int heroSlain;
    private int villainMove = -1;
    private List<Integer> elementList = Arrays.asList(fire, earth, wind, ice, shock);


    /**
     * Method: Constructor for Villain.
     * Inputs: mediator : MediatorBase, name : String
     * Returns: NA
     * Description: Build the villain objects.
     */
    public Villain(MediatorBase mediator, String name) {
        super(mediator);
        this.name = name;
        setBaseElements(elementList);

        health = 100;
        heroSlain = 0;
        strength = ThreadLocalRandom.current().nextInt(0, 9);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMove() {
        return villainMove;
    }

    public int getStrength() {
        return strength;
    }

    public void setResting() {
        this.resting = false;
        health = 100;
    }

    @Override
    public void setBaseElements(List<Integer> list) {

        int min = ThreadLocalRandom.current().nextInt(0, 2);
        int max = ThreadLocalRandom.current().nextInt(2, 11);

        try {
            for (int i = 0; i < list.size(); i++) {
                int rand = ThreadLocalRandom.current().nextInt(min, max);
                list.set(i, rand);
            }
        } catch (NullPointerException e) {
            System.out.println("Element list is pointing to null.");
        }
    }

    @Override
    public void processMove(int move) {

        if (move < 0 || move > 3) {
            throw new NullPointerException("Improper move - not set correctly.");
        }
        if (move == 0) {
            System.out.println("Battle initiated.");
        }
        if (move == 1) {
            System.out.println("The Hero uses a physical attack!");
        }
        if (move == 2) {
            System.out.println("The Hero attacks using the elements!");
        }
        if (move == 3) {
            System.out.println("The Hero take a defensive stance!");
        }
        deductDamage(move);
        villainMove = setRandomMove();
    }

    @Override
    public int setRandomMove() {

        return ThreadLocalRandom.current().nextInt(1, 4);
    }

    @Override
    public void deductDamage(int move) {

        int hit = 0;

        if (move <= 0 || move == 3) {
            System.out.println(name + " takes no damage.");
        }
        if (move == 1) {
            hit = physicalAttack();
        }
        if (move == 2) {
            hit = elementalAttack();
        }
        health = health - hit;
        if (health < 0) {
            health = 0;
        }
        System.out.println(getName() + " has " + health + " health remaining.");
    }

    @Override
    public boolean criticalHitChance() {

        int[] crit = {2, 5, 7};
        int rand = ThreadLocalRandom.current().nextInt(0, 9);
        for (int i : crit) {
            if (i == rand) {
                return true;
            }
        }
        return false;
    }

    /**
     * Method: Physical attack calculation.
     * Inputs: NA
     * Returns: hit : int
     * Description: Private helper method to calculate physical attack.
     */
    private int physicalAttack() {

        int hit = ThreadLocalRandom.current().nextInt(0, 13);
        hit = hit + getStrength();

        if (criticalHitChance()) {
            hit = hit * 2;
            if (hit == 0) {
                System.out.println("Hero tries to hit and misses! " + name + " takes "
                        + hit + " damage.");
            }
            System.out.print(name + " takes a critical hit! ");
        }
        System.out.println(name + " takes a hit for " + hit + " damage!");
        return hit;
    }

    /**
     * Method: Elemental attack calculation.
     * Inputs: NA
     * Returns: hit : int
     * Description: Private helper method to calculate elemental attack.
     */
    private int elementalAttack() {

        int hit = ThreadLocalRandom.current().nextInt(0, elementList.size());
        int bonus = ThreadLocalRandom.current().nextInt(0, 11);
        hit = (elementList.get(hit) + hit) + bonus;

        if (criticalHitChance()) {
            hit = hit * 2;
            if (hit == 0) {
                System.out.println("Hero misses with an elemental attack! " + name + " takes "
                        + hit + " damage.");
            }
            System.out.print(name + " takes a critical hit! ");
        }
        System.out.println(name + " takes elemental hit for " + hit + " damage!");
        return hit;
    }


    /**
     * Method: Receives Message from mediator
     * Inputs: NA
     * Returns: void
     * Description: This method will receive information from the mediator related
     * to combat between villain and hero.
     */
    public void receive(int move, boolean isResting, boolean isDead) {

//        System.out.print(name + " received message. ");
        System.out.print("Move: " + move + ". ");
        System.out.print("Is Hero resting? " + isResting + ". ");
        System.out.println("Is Hero dead? " + isDead);

        if (isDead) {
            System.out.print("The Hero has been defeated! ");
            resting = true;
            consumePower();
            send(99);
            heroSlain = heroSlain + 1;
            System.out.println(name + " has defeated " + heroSlain + " heroes!");
        } else if (isResting) {
            System.out.print("The Hero was defeated while resting! ");
            consumePower();
            send(99);
            heroSlain = heroSlain + 1;
            System.out.println(name + " has defeated " + heroSlain + " heroes!");
        } else {
            processMove(move);
            send(getMove());
        }
    }

    /**
     * Method: Sends messages to the Mediator
     * Inputs: NA
     * Returns: void
     * Description: This method will send information to the mediator related
     * to the combat between villain and hero.
     */
    public void send(int move) {

//        System.out.println(name + " is sending combat message.");
        mediator.sendMessage(this, move);
    }


    @Override
    public boolean isResting() {
        return resting;
    }

    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void consumePower() {

        for (int i = 0; i < 4; i++) {
            int rand = ThreadLocalRandom.current().nextInt(0, elementList.size());
            elementList.set(rand, elementList.get(rand) + 3);
        }
        System.out.println(name + " consumed the Hero's energy and gained elemental power!");

        int bonusStrength = ThreadLocalRandom.current().nextInt(1, 3);
        if (bonusStrength == 1) {
            System.out.print(name + " gained physical strength! Current strength: "
                    + getStrength());
            System.out.print(". 3 strength added. ");
            strength = strength + 3;
            System.out.println(name + "'s strength is now " + getStrength());
        }
    }
}
