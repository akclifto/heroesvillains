package mediator;


/**
 * File: CombatBase.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: Abstract Class that will send moves to the Mediator
 * via MediatorBase related to the villain and hero objects.
 */
public abstract class CombatBase {

    protected MediatorBase mediator;

    public CombatBase(MediatorBase mediator) {
        this.mediator = mediator;
    }

}