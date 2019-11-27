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

    public List<HotSpot> getHotspotList() {
        return hotspotList;
    }

    public HeroBase getHeroBase() {
        return heroBase;
    }

    public VillainLair getVillainLair() {
        return villainLair;
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

        boolean needHotspot = false;

        if (hotspotList.size() == 0) {
            initHotspot(city);
        }

        for (Object item : hotspot.getHotspots()) {

            if (item instanceof HeroBase) {
                needHotspot = true;
            }
            if (item instanceof VillainLair) {
                needHotspot = true;
            }
        }
        if (needHotspot) {
            hotspot = new HotSpot(city);
            hotspotList.add(hotspot);
            System.out.println("Adding a new hotspot.");
            System.out.println("Hotspot added: "
                    + hotspotList.get(hotspotList.size() - 1).getName());
        } else {
            System.out.print(city + " was not created! ");
            System.out.println("The current city does not contain one Lair and one Base.");

        }
    }

    @Override
    public void createBase() {

        HeroBase temp = bases.get(bases.size() - 1);
        if (temp.isBaseFull()) {
            createHotspot("AutoHotspot");
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
            createHotspot("AutoHotspot");
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
