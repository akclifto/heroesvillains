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
        createBase();
        createLair();
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

        heroBase = new HeroBase();
        bases.add(heroBase);
        System.out.println("A new hero base has been added to the planet.");
    }

    @Override
    public void createLair() {

        villainLair = new VillainLair();
        lairs.add(villainLair);
        System.out.println("A new villain lair has been added to the planet.");
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
