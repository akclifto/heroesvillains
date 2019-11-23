package factory;

import java.util.ArrayList;
import java.util.List;


public class HotSpotFactory extends Factory {

    private VillainLair villainLair;
    private HeroBase heroBase;
    private List<Object> lairs = new ArrayList<>();
    private List<Object> bases = new ArrayList<>();

    public HotSpotFactory() {
        //ctor
    }

    @Override
    public LairBase createBase(String name) {

        heroBase = new HeroBase(name);
        bases.add(heroBase);
        System.out.println("A new hero base has been added to the planet.");
        return heroBase;

    }

    @Override
    public LairBase createLair(String name) {
        villainLair = new VillainLair(name);
        lairs.add(villainLair);
        System.out.println("A new villain lair has been added to the planet.");
        return villainLair;
    }

}
