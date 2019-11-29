package mediator;


import java.util.ArrayList;
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
    private int health = 100;
    private int villainMove = 0;
    private List<Integer> ElementList = Arrays.asList(fire, earth, wind, ice, shock);
    private List<Villain> villainList = new ArrayList<>();



    public Villain(MediatorBase mediator, String name) {
        super(mediator);
        this.name = name;
        setBaseElements(ElementList);
        villainList.add(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Villain> getVillainList() {
        return villainList;
    }

    public int getMove() {
        return villainMove;
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


    /**
     * Method: Receives Message from mediator
     * Inputs: NA
     * Returns: void
     * Description: This method will receive information from the mediator related
     * to combat between villain and hero.
     */
    public void receive(int move, boolean isResting, boolean isDead) {
        //TODO receive me, deduct damage, check resting/dead, send new move
        System.out.println("Villain received message");
        System.out.println("Move; " + move );
        System.out.println("is Villain resting: " + isResting);
        System.out.println("is Villain dead: " + isDead);
        //TODO
        villainMove = 9;
        send(9, false, false);
    }

    /**
     * Method: Sends messages to the Mediator
     * Inputs: NA
     * Returns: void
     * Description: This method will send information to the mediator related
     * to the combat between villain and hero.
     */
    public void send(int move, boolean isResting, boolean isDead) {

        System.out.println("Villain is sending combat message.");
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
