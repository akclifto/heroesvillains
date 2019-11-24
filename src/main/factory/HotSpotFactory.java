package factory;

import java.util.ArrayList;
import java.util.List;


public class HotSpotFactory extends Factory {

    private VillainLair villainLair;
    private HeroBase heroBase;
    private List<VillainLair> lairs = new ArrayList<>();
    private List<HeroBase> bases = new ArrayList<>();
    private HotSpot hotspot;
    private List<HotSpot> hotspotList = new ArrayList<>();


    public HotSpotFactory() {
        //ctor
    }

    public List<VillainLair> getLairs() {
        return lairs;
    }

    public List<HeroBase> getBases() {
        return bases;
    }

    @Override
    public void initHotspot(String city) {

        hotspot = new HotSpot(city);
        hotspotList.add(hotspot);
        System.out.println("A new hotspot has been created: " + city);

        heroBase = new HeroBase();
        bases.add(heroBase);
        hotspot.addBase(heroBase);
        System.out.println("A new hero base has been added to "
                + hotspotList.get(hotspotList.size() - 1).getName());

        villainLair = new VillainLair();
        lairs.add(villainLair);
        hotspot.addLair(villainLair);
        System.out.println("A new villain lair has been added to "
                + hotspotList.get(hotspotList.size() - 1).getName());
    }

    @Override
    public void createHotspot(String city) {

        if ((hotspot.checkLair()) || (hotspot.checkBase())) {
            hotspot = new HotSpot(city);
            hotspotList.add(hotspot);
        } else {
            System.out.println(" Creating hotspot stopped.  "
                    + "City does not contain one Lair and one Base.");
        }
    }

    @Override
    public void createBase() {

        HeroBase temp = bases.get(bases.size() - 1);
        if (temp.isBaseFull()) {
            heroBase = new HeroBase();
            bases.add(heroBase);
            hotspot.addBase(heroBase);
            System.out.println("A new hero base has been added to "
                    + hotspotList.get(hotspotList.size() - 1).getName());
        } else {
            System.out.println("Hero Base is not full.  No new Hero Base created.");
            System.out.println("Hero Base contains " + heroBase.getPopulation() + " Heroes!");
        }
    }

    @Override
    public void createLair() {

        VillainLair temp = lairs.get(lairs.size() - 1);
        if (temp.isLairFull()) {
            villainLair = new VillainLair();
            lairs.add(villainLair);
            hotspot.addLair(villainLair);
            System.out.println("A new villain lair has been added to "
                    + hotspotList.get(hotspotList.size() - 1).getName());
        } else {
            System.out.println("Villain Lair is not full.  No new Lair created.");
            System.out.println("Villain Lair contains "
                    + villainLair.getPopulation() + " Villains!");
        }
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
