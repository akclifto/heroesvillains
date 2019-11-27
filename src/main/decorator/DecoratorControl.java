package decorator;


import java.util.ArrayList;
import java.util.List;

public class DecoratorControl {

    private ConcreteSuperPower conc = new ConcreteSuperPower();
    private Hero hero;
    private Villain villain;
    private List<Hero> heroList = new ArrayList<>();
    private List<Villain> villainList = new ArrayList<>();

    /**
     * Method: Runs the decorator design simulation
     * Inputs: NA
     * Returns: void
     * Description: This method will run the factory design.  It will:
     *  - spawn heroes and villains.
     *  - give heroes and villains powers.
     *  - allows heroes and villains to spawn children.
     *  - give chance of random normal person to become a hero.
     *  - create a new bases or lairs if size exceeds 5 dwellers.
     *  - balance villain powers with hero powers.
     */
    public void run() {

        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Starting the Decorator simulation...");
        System.out.println("-----------------------------------------------");

        conc.createHero("Thor");
        conc.spawnVillain("Loki");

        conc.createHero("Freya");
        conc.spawnVillain("Astrid");

        System.out.println("Hero " + conc.getSpawnedHeroes().get(1).getName()
                + " gains power.");
        conc.addPower("Freya", );






    }

}
