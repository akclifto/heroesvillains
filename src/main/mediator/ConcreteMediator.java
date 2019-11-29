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
    private boolean isResting = false;
    private boolean isDead = false;

    @Override
    public void sendMessage(CombatBase caller) {

        try {
            if (caller == hero) {
                hero.receive(isResting, isDead);
            }
            if (caller == villain) {
                villain.receive();
            }
        } catch (Exception e)  {
            System.out.println("Message was not sent properly.");
            e.printStackTrace();
        }
    }

    @Override
    public void getMessage(CombatBase caller, boolean isResting, boolean isDead) {

        try{
            if(caller == hero) {

            }

        } catch (Exception e) {
            System.out.println("Message was not received properly.");
            e.printStackTrace();
        }
    }
}
