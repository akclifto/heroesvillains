package mediator;

import java.util.List;

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


    /**
     * Method: Relays messages to the Mediator
     * Inputs: NA
     * Returns: void
     * Description: Gets the name of the hero or villains and passes to mediator.
     */
    public abstract String getName();

    /**
     * Method: Gets the move set from the Hero or Villain.
     * Inputs: NA
     * Returns: hero's or villain's move : int
     * Description: This method gets the hero or villain's move set to be sent
     * to the opposition through the mediator.
     */
    public abstract int getMove();

    /**
     * Method: Processes the move sent from the opposing player through the mediator.
     * Inputs: move : int
     * Returns: void
     * Description: This method will take the move sent from the mediator and apply
     * the move against the receiving player. The int values of the move correspond to
     * the following:
     *      0 = Battle Initiated.
     *      1 = Physical attack
     *      2 = Elemental attack
     *      3 = Defensive stance, no attack
     */
    public abstract void processMove(int move);

    /**
     * Method: Sets a random move to be sent from the hero or villain.
     * Inputs: NA
     * Returns: hero's or villain's move : int
     * Description: This method will set a random move for the hero or villain
     * to send to the opposition.
     */
    public abstract int setRandomMove();

    /**
     * Method: Sets base elements for Heroes and Villains.
     * Inputs: list : List, min : int, max : int
     * Returns: void
     * Description: This method will set base attirbutes for both Heroes and Villains
     * and allows the user to set custom min, max options for both.
     */
    public abstract void setBaseElements(List<Integer> list);

    /**
     * Method: Deduct damage based on the move used.
     * Inputs:
     * Returns: NA
     * Description: This method will calculate the damage received from given move.
     */
    public abstract void deductDamage(int move);


    /**
     * Method: Chance to get a critical strike on opponent.
     * Inputs: NA
     * Returns: boolean
     * Description: This method will give a chance at a critical strike.
     * Returns true if the move is a critical strike; false otherwise.
     */
    public abstract boolean criticalHitChance();


}
