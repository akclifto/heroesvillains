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

    @Override
    public void sendMessage(CombatBase caller) {

        boolean isResting = false;
        boolean isDead = false;
        
        try {
            if (caller == hero) {
                hero.receive();
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
