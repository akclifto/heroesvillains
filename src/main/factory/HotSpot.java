package factory;

import java.util.ArrayList;
import java.util.List;

public class HotSpot {

    private String name;
    private List<String> cities = new ArrayList<>();
    private List<LairBase> hotspots = new ArrayList<>();


    public HotSpot(String name) {
        this.name = name;
        cities.add(name);
    }

    public void addLair(VillainLair lair) {
        if (!checkLair()) {
            hotspots.add(lair);
        } else {
            System.out.println("Lair not added. Hotspot already contains a Lair.");
        }
    }

    public void addBase(HeroBase base) {
        if (!checkBase()) {
            hotspots.add(base);
        } else {
            System.out.println("Base not added. Hot already contains a Base.");
        }
    }

    public boolean checkLair() {

        for (Object item : hotspots) {
            if (item instanceof VillainLair) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean checkBase() {

        for (Object item : hotspots) {
            if (item instanceof VillainLair) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
