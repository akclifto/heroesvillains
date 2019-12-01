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
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMove() {
        return heroMove;
    }


    @Override
    public void processMove(int move) {

        if (move < 0 || move > 3) {
            throw new NullPointerException("Improper move - not set correctly.");
        }
        if (move == 0) {
            System.out.println("Battle initiated.");
            heroMove = setRandomMove();
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

    }

    @Override
    public int setRandomMove() {

        return ThreadLocalRandom.current().nextInt(1, 4);

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


    /**
     * Method: Receives Message from mediator
     * Inputs: NA
     * Returns: void
     * Description: This method will receive information from the mediator related
     * to combat between villain and hero.
     */
    public void receive(int move, boolean isResting, boolean isDead) {

        processMove(move);
        System.out.println("Hero received message");
        //TODO deduct damage, check resting/dead, send new move

        System.out.print("Move: " + move + ". ");
        System.out.print("Is Villain resting? " + isResting + ". ");
        System.out.println("Is Villain dead? " + isDead);
        //TODO set hero move
        heroMove = 2;
        send(getMove(), false, false);
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
