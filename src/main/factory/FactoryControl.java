package factory;

import java.util.ArrayList;
import java.util.List;

public class FactoryControl {

    public HotSpotFactory hot = new HotSpotFactory();
    public HeroBase heroBase;
    public List<HeroBase> heroBaseList = new ArrayList<>();
    public VillainLair villainLair;
    public List<VillainLair> villainLairList = new ArrayList<>();

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


    }

}
