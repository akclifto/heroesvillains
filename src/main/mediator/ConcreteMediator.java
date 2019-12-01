package mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * File: ConcreteMediator.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: This class will control the communication between the Hero and Villain
 * objects when they battle.
 */
public class ConcreteMediator implements MediatorBase {

    private Hero hero;
    private Villain villain;
    private int heroCount = 0;
    private int villainCount = 0;
    private List<Hero> heroList = new ArrayList<>();
    private List<Villain> villainList = new ArrayList<>();


    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return hero;
    }

    public void setVillain(Villain villain) {
        this.villain = villain;
    }

    public Villain getVillain() {
        return villain;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public List<Villain> getVillainList() {
        return villainList;
    }


    @Override
    public void sendMessage(CombatBase caller, int move) {

        try {
            if (caller == hero) {
                villainReceive(move);
            }
            if (caller == villain) {
                heroReceive(move);
            }
        } catch (Exception e) {
            System.out.println("Message was not sent properly.");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {

        for (int i = 0; i < 10; i++) {

            hero = new Hero(this, "Hero " + heroCount++);
            System.out.print("Hero " + heroCount + " created. ");
            heroList.add(hero);

            villain = new Villain(this, "Villain " + villainCount++);
            System.out.println("Villain " + villainCount + " created.");
            villainList.add(villain);
        }

        System.out.println("Total Heroes: " + heroList.size());
        System.out.println("Total Villains: " + villainList.size());


    }

    /**
     * Method: Initiates the start of the simulation.
     * Inputs: NA
     * Returns: void
     * Description: This method creates base heroes and villains, and
     * chooses one side to initiate combat at random.
     */
    @Override
    public void initiateRandom() {

        int firstMove = ThreadLocalRandom.current().nextInt(0, 11);
        firstMove = firstMove % 2;

        if (firstMove == 1) {
            System.out.println("The Hero makes the first move.");
            hero.receive(0, false, false);
        } else {
            System.out.println("The villain makes the first move.");
            villain.receive(0, false, false);
        }
    }


    /**
     * Method: Sends villain message from hero.
     * Inputs: NA
     * Returns: void
     * Description: Helper method used in sendMessage to send message to villain.
     */
    private void villainReceive(int move) {

        System.out.print("Mediator received message. ");
        if (hero.isDead()) {
            System.out.println("Hero has been slain");
            villain.receive(move, false, true);
        } else if (hero.isResting()) {
            System.out.println("Hero is resting.");
            villain.receive(move, true, false);
        } else {
            System.out.println("Mediator sends move to villain");
            villain.receive(move, false, false);
        }
    }

    /**
     * Method: Sends hero message from villain.
     * Inputs: NA
     * Returns: void
     * Description: Helper method used in sendMessage to send message to hero.
     */
    private void heroReceive(int move) {
        System.out.print("Mediator received message. ");
        if (villain.isDead()) {
            System.out.println("Villain has been slain.");
            hero.receive(move, false, true);
        } else if (villain.isResting()) {
            System.out.println("Villain is resting.");
            hero.receive(move, true, false);
        } else {
            System.out.println("Mediator sends move to Hero.");
            hero.receive(move, false, false);
        }
    }
}
