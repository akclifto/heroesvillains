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
        System.out.println("Move definitions:");
        System.out.println("Move 1 = physical attack.");
        System.out.println("Move 2 = elemental attack.");
        System.out.println("Move 3 = defensive stance.");
        System.out.println();


        med.initialize();
        med.newBattle();
    }
}

