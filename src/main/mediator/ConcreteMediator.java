package mediator;


import java.sql.SQLOutput;

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
    private int move = 0;


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


    @Override
    public void sendMessage(CombatBase caller, int move) {

        try {
            if (caller == hero) {
                System.out.println("Mediator received message.");
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
            if (caller == villain) {
                System.out.println("Mediator received message.");
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
        } catch (Exception e)  {
            System.out.println("Message was not sent properly.");
            e.printStackTrace();
        }
    }

}
