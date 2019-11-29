package decorator;


/**
 * File: DecoratorControl.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: This class will run the decorator design simulation.
 */
public class DecoratorControl {

    private ConcreteSuperPower conc = new ConcreteSuperPower();

    /**
     * Method: Runs the decorator design simulation
     * Inputs: NA
     * Returns: void
     * Description: This method will run the factory design.  It will:
     * - spawn heroes and villains.
     * - give heroes and villains powers.
     * - allows heroes and villains to spawn children.
     * - give chance of random normal person to become a hero.
     * - create a new bases or lairs if size exceeds 5 dwellers.
     * - balance villain powers with hero powers.
     */
    public void run() {

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Starting the Decorator simulation...");
        System.out.println("-----------------------------------------------");


        conc.createHero("Thor");
        System.out.println("Citizen have a chance to become heroes!");
        System.out.println();
        conc.spawnVillain("Loki");
        System.out.println();

        System.out.println("Heroes spawn with more power than villains!");
        System.out.println("Both heroes and villains inherit powers from their parent.");
        conc.createHero("Freya");
        System.out.println();
        conc.spawnVillain("Astrid");

        System.out.println();
        System.out.println("Heroes and Villains can gain power!");
        System.out.println("Hero " + conc.getSpawnedHeroes().get(1).getName()
                + " gains Earthen power!");
        System.out.println("Current earth power: "
                + conc.getSpawnedHeroes().get(1).getElementList().get(1));
        conc.addPower("Freya", 1, 5);
        System.out.println(conc.getSpawnedHeroes().get(1).getName()
                + "'s New earth power: "
                + conc.getSpawnedHeroes().get(1).getElementList().get(1));

        System.out.println();
        System.out.println("Villain " + conc.getSpawnedVillains().get(1).getName()
                + " gains Fire power!");
        System.out.println("Current fire power: "
                + conc.getSpawnedVillains().get(1).getElementList().get(0));
        conc.addPower("Astrid", 0, 5);
        System.out.println(conc.getSpawnedVillains().get(1).getName()
                + "'s New earth power: "
                + conc.getSpawnedVillains().get(1).getElementList().get(0));
        System.out.println();
        System.out.println("Heroes are born to, and villains spawn from, a random parent!");
        conc.createHero("Hrothgar");
        System.out.println();
        conc.createHero("Solveig");
        System.out.println();
        conc.createHero("Gorm");

        System.out.println();
        conc.spawnVillain("Sigrid");
        System.out.println();
        conc.spawnVillain("Bjorn");
        System.out.println();
        conc.spawnVillain("Halfdan");

        System.out.println();
        System.out.println("Concluding Decorator simulation...");
        System.out.println();
    }

}
