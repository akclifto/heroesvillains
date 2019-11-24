package factory;

import java.util.ArrayList;
import java.util.List;

public class FactoryControl {

    private HotSpotFactory hot = new HotSpotFactory();
    private HeroBase heroBase;
    private List<HeroBase> heroBaseList = new ArrayList<>();
    private VillainLair villainLair;
    private List<VillainLair> villainLairList = new ArrayList<>();

    public void run() {


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


        int num = 10;
        while (num > 0) {

            if (heroBase.isBaseFull()) {
                hot.createBase();
                break;
            }
            System.out.println("adding dwellers to HeroBase.");
            heroBase.addDweller("d1");
            heroBase.addDweller("d2");
            heroBase.addDweller("d3");
            heroBase.addDweller("d4");
            heroBase.addDweller("d5");
            heroBase.addDweller("d6");
        }
        for (int i = 0 ; i < heroBase.getDwellerList().size(); i++) {
            //
        }




    }

}
