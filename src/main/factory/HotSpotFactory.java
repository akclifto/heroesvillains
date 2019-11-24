package factory;

import java.util.ArrayList;
import java.util.List;


public class HotSpotFactory extends Factory {

    private VillainLair villainLair;
    private HeroBase heroBase;
    private List<VillainLair> lairs = new ArrayList<>();
    private List<HeroBase> bases = new ArrayList<>();
    private HotSpot hotspot;


    public HotSpotFactory() {
        //ctor
    }

    public List<VillainLair> getLairs() {
        return lairs;
    }

    public List<HeroBase> getBases() {
        return bases;
    }

    public void initHotspot(String city) {

        hotspot = new HotSpot(city);
        System.out.println("A new hotspot has been created: " + city);
        createBase();
        createLair();
    }





    @Override
    public LairBase createBase() {

        heroBase = new HeroBase();
        bases.add(heroBase);
        System.out.println("A new hero base has been added to the planet.");
        return heroBase;
    }

    @Override
    public LairBase createLair() {

        villainLair = new VillainLair();
        lairs.add(villainLair);
        System.out.println("A new villain lair has been added to the planet.");
        return villainLair;
    }

    @Override
    public void removeLair(LairBase obj) {

        lairs.remove(obj);
    }

    @Override
    public void removeBase(LairBase heroBase) {

        bases.remove(heroBase);
    }

}
