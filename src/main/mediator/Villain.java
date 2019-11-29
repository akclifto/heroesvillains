package mediator;


/**
 * File: Villain.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: This class will hold the Villains that do battle with
 * the Heroes.  Communication will run through the mediator.
 */
public class Villain extends CombatBase {

    public Villain(MediatorBase mediator) {
        super(mediator);
    }

    @Override
    public String getName() {
        return null;
    }


    /**
     * Method: Receives Message from mediator
     * Inputs: NA
     * Returns: void
     * Throws: Exception is message is not sent properly.
     * Description: This method will receive information from the mediator related
     * to combat between villain and hero.
     */
    public void receive() {
        //TODO
    }

    /**
     * Method: Sends messages to the Mediator
     * Inputs: NA
     * Returns: void
     * Description: This method will send information to the mediator related
     * to the combat between villain and hero.
     */
    public void send() {
        //TODO
    }


}
