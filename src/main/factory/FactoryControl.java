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

        //TODO build out controller proper
        System.out.println("Creating initial Hotspot...");
        hot.initHotspot("Gotham");
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Starting factory...");
        hot.createBase();
        hot.createLair();
        heroBaseList = hot.getBases();
        heroBase = heroBaseList.get(0);

        villainLairList = hot.getLairs();
        villainLair = villainLairList.get(0);

        heroBase.addDweller("DumbleDore");

        System.out.println("Hero base pop: " + heroBase.getPopulation());
        System.out.println("Villain lair pop: " + villainLair.getPopulation());

        villainLair.addDweller("Bilbo");
        villainLair.addDweller("Cornelius");
        System.out.println("Villain lair pop: " + villainLair.getPopulation());
        villainLair.removeDweller("Cornelius");
        System.out.println("Villain lair pop: " + villainLair.getPopulation());
        heroBase.removeDweller("Jildon");
        System.out.println("Hero base pop: " + heroBase.getPopulation());

        System.out.println(heroBase.getElementList());
        System.out.println(villainLair.getElementList());

        int num = 1;
        for (int i = 0; i < 10; i++) {
            if (heroBase.isBaseFull()) {
                hot.createBase();
                heroBaseList = hot.getBases();
                heroBase = heroBaseList.get(heroBaseList.size() - 1);
            }
            System.out.println("adding dwellers to HeroBase.");
            heroBase.addDweller("d" + String.valueOf(num++));
        }




    }

}
