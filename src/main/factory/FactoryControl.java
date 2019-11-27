package factory;

import java.util.ArrayList;
import java.util.List;

public class FactoryControl {

    private HotSpotFactory hot = new HotSpotFactory();
    private HeroBase heroBase;
    private List<HeroBase> heroBaseList = new ArrayList<>();
    private VillainLair villainLair;
    private List<VillainLair> villainLairList = new ArrayList<>();

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

        System.out.println("----------------------------------------------------");
        System.out.println("Starting the Factory simulation...");
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println("The initial hotspot automatically creates a hero base "
                + "and villain lair!");
        System.out.println("Creating initial Hotspot...");
        hot.initHotspot("Gotham");
        System.out.println();
        System.out.println();
        hot.createHotspot("Shamus");
        hot.createHotspot("Rommo");
        System.out.println("Creating bases and lairs...");
        hot.createBase();
        hot.createLair();
        heroBaseList = hot.getBases();
        heroBase = heroBaseList.get(0);

        villainLairList = hot.getLairs();
        villainLair = villainLairList.get(0);
        System.out.println();

        System.out.println("Heroes and villains can be added to bases and lairs!");
        heroBase.addDweller("DumbleDore");
        System.out.println("Hero base pop: " + heroBase.getPopulation());
        System.out.println("Villain lair pop: " + villainLair.getPopulation());
        villainLair.addDweller("Bilbo");
        villainLair.addDweller("Cornelius");
        System.out.println("Hero base pop: " + heroBase.getPopulation());
        System.out.println("Villain lair pop: " + villainLair.getPopulation());
        villainLair.removeDweller("Cornelius");
        System.out.println("Hero base pop: " + heroBase.getPopulation());
        System.out.println("Villain lair pop: " + villainLair.getPopulation());
        heroBase.removeDweller("Jildon");
        System.out.println("Hero base pop: " + heroBase.getPopulation());
        System.out.println("Villain lair pop: " + villainLair.getPopulation());
        System.out.println();

        System.out.println("Each base and lair has base elements that assist their dwellers!");
        System.out.println("Hero base element list: " + heroBase.getElementList());
        System.out.println("Villain lair element list: " + villainLair.getElementList());
        System.out.println();

        System.out.println("New bases, lairs, and hotpots are added as each fill up!");
        System.out.println();
        int num = 1;
        for (int i = 0; i < 10; i++) {
            if (heroBase.isBaseFull()) {
                hot.createBase();
                heroBaseList = hot.getBases();
                heroBase = heroBaseList.get(heroBaseList.size() - 1);
                System.out.println("Hero base element list: " + heroBase.getElementList());
            }
            System.out.println("Adding dwellers to Hero Bases...");
            heroBase.addDweller("H " + num++);
            System.out.println("Hero Base pop: " + heroBase.getPopulation());
        }

        System.out.println();
        int vill = 1;
        for (int i = 0; i < 10; i++) {
            if (villainLair.isLairFull()) {
                hot.createLair();
                villainLairList = hot.getLairs();
                villainLair = villainLairList.get(villainLairList.size() - 1);
                System.out.println("Villain lair element list: " + villainLair.getElementList());
            }
            System.out.println("Adding dwellers to Villain Lairs...");
            villainLair.addDweller("V " + vill++);
            System.out.println("Villain Lair pop: " + villainLair.getPopulation());
        }


        System.out.println();
        System.out.println("Concluding Factory simulation...");
    }

}
