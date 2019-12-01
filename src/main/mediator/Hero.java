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
        strength = ThreadLocalRandom.current().nextInt(0, 11);
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


    @Override
    public void setBaseElements(List<Integer> list) {

        int min = ThreadLocalRandom.current().nextInt(0, 3);
        int max = ThreadLocalRandom.current().nextInt(3, 12);

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
            System.out.println("Hero takes no damage.");
        }
        if (move == 1) {
            hit = ThreadLocalRandom.current().nextInt(0, 6);
            hit = hit + getStrength();

            if (criticalHitChance()) {
                hit = hit * 2;
                if (hit == 0) {
                    System.out.println("Villain tries to hit and misses! Hero takes "
                            + hit + " damage.");
                }
                System.out.println("Hero takes critical hit for " + hit + " damage!");
            }
            System.out.println("Hero takes a hit for " + hit + " damage!");
        }
        if (move == 2) {
            int rand = ThreadLocalRandom.current().nextInt(0, 5);
            hit = elementList.get(rand) + rand;

            if(criticalHitChance()) {
                hit = hit * 2;
                if (hit == 0) {
                    System.out.println("Villain misses with an elemental attack! Hero takes "
                            + hit + " damage.");
                }
                System.out.println("Hero takes critical elemental hit for " + hit + " damage!");
            }
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
        int rand = ThreadLocalRandom.current().nextInt(0, 10);
        for (int i : crit) {
            if (i == rand) {
                return true;
            }
        }
        return false;
    }


    /**
     * Method: Receives Message from mediator
     * Inputs: NA
     * Returns: void
     * Description: This method will receive information from the mediator related
     * to combat between villain and hero.
     */
    public void receive(int move, boolean isResting, boolean isDead) {

        System.out.print("Hero received message. ");
        if (isDead || isResting) {
            System.out.println("The Villain has been defeated!");
            //TODO take villains power!
        }
        processMove(move);


        //TODO send new move

        System.out.print("Move: " + move + ". ");
        System.out.print("Is Villain resting? " + isResting + ". ");
        System.out.println("Is Villain dead? " + isDead);
        //TODO set hero move
        heroMove = 2;
        send(getMove(), this.isResting(), this.isDead());
    }

    /**
     * Method: Sends messages to the Mediator
     * Inputs: move : int, isResting : boolean, isDead : booleans
     * Returns: void
     * Description: This method will send information to the mediator related
     * to the combat between villain and hero.
     */
    public void send(int move, boolean isResting, boolean isDead) {

        System.out.println("Hero is sending combat message.");
        mediator.sendMessage(this, move);
    }



    public boolean isResting() {
        //TODO if just fought, need to rest, will have to use a tick or something
        return false;
    }

    public boolean isDead() {
        return health <= 0;
    }





}
