package mediator;


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

    @Override
    public void sendMessage(CombatBase caller, int move, boolean isResting, boolean isDead) {

        try {
            if (caller == hero) {
                hero.receive(move, isResting, isDead);
            }
            if (caller == villain) {
                villain.receive();
            }
        } catch (Exception e)  {
            System.out.println("Message was not sent properly.");
            e.printStackTrace();
        }
    }

}
