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
    public LairBase createBase() {

        heroBase = new HeroBase();
        heroBase.setElements();
        bases.add(heroBase);
        System.out.println("A new hero base has been added to the planet.");
        return heroBase;

    }

    @Override
    public void removeLair(LairBase obj) {


        lairs.remove(obj);

    }

    @Override
    public void removeBase(LairBase obj) {

        bases.remove(obj);
    }

    @Override
    public LairBase createLair() {

        villainLair = new VillainLair();
        villainLair.setElements();
        lairs.add(villainLair);
        System.out.println("A new villain lair has been added to the planet.");
        return villainLair;
    }

}
