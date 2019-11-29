package mediator;


/**
 * File: MediatorControl.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: This is the control class that will run the Mediator design
 * simulation.
 */
public class MediatorControl {

    private ConcreteMediator med = new ConcreteMediator();

    /**
     * Method: Runs the factory design simulation
     * Inputs: NA
     * Returns: void
     * Description: This method will run the factory design.  It will:
     *  - create hotspots of Hero bases and Villain lairs.
     *  - add elemental attributes to strengthen/weaken hero dwellers or villain dwellers.
     *  - add dwellers to bases and lairs.
     *  - create a new bases or lairs if size exceeds 5 dwellers.
     */
    public void run() {

        //TODO
        System.out.println("----------------------------------------------------");
        System.out.println("Starting the Mediator simulation...");
        System.out.println("----------------------------------------------------");

        Hero hero1 = new Hero(med, "Hero");
        med.setHero(hero1);
        Villain villain1 = new Villain(med, "Villain");
        med.setVillain(villain1);

        hero1.send(2, false, false);
        villain1.send(9, false, false);

    }

}
