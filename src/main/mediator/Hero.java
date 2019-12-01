package mediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * File: Hero.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: This class will hold the Heroes that do battle with
 * the Villains.  Communication will run through the mediator.
 */
public class Hero extends CombatBase {

    private String name;
    private int fire = 0;
    private int earth = 0;
    private int wind = 0;
    private int ice = 0;
    private int shock = 0;
    private int health;
    private int strength;
    private boolean resting = false;
    private int villainSlain;
    private int heroMove = -1;
    private List<Integer> elementList = Arrays.asList(fire, earth, wind, ice, shock);

    /**
     * Method: Constructor for Hero.
     * Inputs: mediator : MediatorBase, name : String
     * Returns: NA
     * Description: Build the hero objects.
     */
    public Hero(MediatorBase mediator, String name) {
        super(mediator);
        this.name = name;
        setBaseElements(elementList);

        health = 100;
        villainSlain = 0;
        strength = ThreadLocalRandom.current().nextInt(3, 12);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMove() {
        return heroMove;
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

        int min = ThreadLocalRandom.current().nextInt(0, 3);
        int max = ThreadLocalRandom.current().nextInt(3, 16);

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
            System.out.println("The villain uses a physical attack!");
        }
        if (move == 2) {
            System.out.println("The Villain attacks using the elements!");
        }
        if (move == 3) {
            System.out.println("The Villain take a defensive stance!");
        }
        deductDamage(move);
        heroMove = setRandomMove();
    }

    @Override
    public int setRandomMove() {

        return ThreadLocalRandom.current().nextInt(1, 4);
    }

    @Override
    public void deductDamage(int move) {

        int hit = 0;

        if (move <= 0 || move == 3) {
            System.out.println(name + " takes no damage!");
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

        int[] crit = {1, 4, 7};
        int rand = ThreadLocalRandom.current().nextInt(0, 11);
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

        int hit = ThreadLocalRandom.current().nextInt(0, 10);
        hit = hit + getStrength();

        if (criticalHitChance()) {
            hit = hit * 2;
            if (hit == 0) {
                System.out.println("Villain tries to hit and misses! " + name + " takes "
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
        int bonus = ThreadLocalRandom.current().nextInt(0, 8);
        hit = (elementList.get(hit) + hit) + bonus;
        if (criticalHitChance()) {
            hit = hit * 2;
            if (hit == 0) {
                System.out.println("Villain misses with an elemental attack! " + name + " takes "
                        + hit + " damage.");
            }
            System.out.print(name + " takes a critical hit! ");
        }
        System.out.println(name + " takes elemental hit for " + hit + " damage!");
        return hit;
    }


    /**
     * Method: Receives Message from mediator.
     * Inputs: NA
     * Returns: void
     * Description: This method will receive information from the mediator related
     * to combat between villain and hero.
     */
    public void receive(int move, boolean isResting, boolean isDead) {

        System.out.print(name + " received message. ");
        System.out.print("Move chosen: " + move + ". ");
        System.out.print("Is Villain resting? " + isResting + ". ");
        System.out.println("Is Villain dead? " + isDead);

        if (isDead) {
            System.out.println("The Villain has been defeated! ");
            resting = true;
            consumePower();
            villainSlain = villainSlain + 1;
            System.out.println(name + " has defeated " + villainSlain + " villains!");
            send(99);

        } else if (isResting) {
            System.out.println("The Villain was defeated while resting! ");
            consumePower();
            villainSlain = villainSlain + 1;
            System.out.println(name + " has defeated " + villainSlain + " villains!");
            send(99);

        } else {
            processMove(move);
            send(getMove());
        }
    }

    /**
     * Method: Sends messages to the Mediator.
     * Inputs: move : int, isResting : boolean, isDead : booleans
     * Returns: void
     * Description: This method will send information to the mediator related
     * to the combat between villain and hero.
     */
    public void send(int move) {

        System.out.println(name + " is sending combat message.");
        mediator.sendMessage(this, move);
    }

    @Override
    public boolean isResting() {
        return resting;
    }

    @Override
    public boolean isDead() {
        return health <= 0;
    }

    @Override
    public void consumePower() {

        for (int i = 0; i < 4; i++) {
            int rand = ThreadLocalRandom.current().nextInt(0, elementList.size());
            elementList.set(rand, elementList.get(rand) + 5);
        }
        System.out.println(name + " consumed the Villain's energy and gained elemental power!");

        int bonusStrength = ThreadLocalRandom.current().nextInt(1, 3);
        if (bonusStrength == 2) {
            System.out.print(name + " gained physical strength! Current strength: "
                    + getStrength());
            System.out.print(". 7 strength added. ");
            strength = strength + 7;
            System.out.println(name + "'s strength is now " + getStrength());
        }
    }
}
