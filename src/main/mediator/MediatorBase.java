package mediator;


/**
 * File: MediatorBase.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: Interface file that is used to communicate between the CombatBase
 * and the ConcreteMediator to get and set moves that will be relayed to
 * the Villain and Hero objects.
 */
public interface MediatorBase {


    /**
     * Method: Relays messages to the Mediator
     * Inputs: caller : CombatBase, move : int, isResting : boolean, isDead : Boolean
     * Returns: void
     * Description: This method relays information from the CombatBase to the
     * mediator regarding the villain and hero objects.
     */
    public void sendMessage(CombatBase caller, int move, boolean isResting, boolean isDead);

}
