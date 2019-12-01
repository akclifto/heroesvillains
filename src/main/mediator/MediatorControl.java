package mediator;


/**
 * File: MediatorControl.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: This is the control class that will run the Mediator design
 * simulation.
 */
public class MediatorControl implements Runnable {

    private ConcreteMediator med = new ConcreteMediator();

    /**
     * Method: Runs the factory design simulation
     * Inputs: NA
     * Returns: void
     * Description: This method will run the factory design.  It will:
     * - create hotspots of Hero bases and Villain lairs.
     * - add elemental attributes to strengthen/weaken hero dwellers or villain dwellers.
     * - add dwellers to bases and lairs.
     * - create a new bases or lairs if size exceeds 5 dwellers.
     */
    public void run() {

        System.out.println("----------------------------------------------------------------");
        System.out.println("Starting the Mediator simulation...");
        System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("Battles are chosen at random between Heroes and Villains. ");
        System.out.println("If either are chosen while resting, they will be "
                + "defeated immediately.");
        System.out.println("Their power will be consumed by the victor and a "
                + "new battle will commmence!");
        System.out.println();

        med.initialize();
        med.newBattle();
    }
}

