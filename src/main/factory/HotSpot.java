package factory;

import java.util.ArrayList;
import java.util.List;

/**
 * File: HotSpot.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: File to create hotspots around the planet. A new hotspot will be
 * created if one hotspot contains both a Base and a Lair.
 */
public class HotSpot {

    private String name;
    private List<String> cities = new ArrayList<>();
    private List<LairBase> hotspots = new ArrayList<>();


    public HotSpot(String name) {
        this.name = name;
        cities.add(name);
    }

    public String getName() {
        return name;
    }

    /**
     * Method: Adds a lair to a hotspot.
     * Inputs: lair : VillainLair
     * Returns: void
     * Description: This method add a new lair to a hotspot.  It will halt if a hotspot
     * already contains a lair.
     */
    public void addLair(VillainLair lair) {
        if (!checkLair()) {
            hotspots.add(lair);
        } else {
            System.out.println("Lair not added. Hotspot already contains a Lair.");
        }
    }

    /**
     * Method: Adds a base to a hotspot.
     * Inputs: base : HeroBase
     * Returns: void
     * Description: This method add a new base to a hotspot.  It will halt if a hotspot
     * already contains a base.
     */
    public void addBase(HeroBase base) {
        if (!checkBase()) {
            hotspots.add(base);
        } else {
            System.out.println("Base not added. Hotspot already contains a Base.");
        }
    }

    /**
     * Method: Checks hotspot to see if it contains a Lair.
     * Inputs: NA
     * Returns: boolean true if it contains a lair.  False, otherwise.
     * Description: Method iterates through list of hotspots to check for an instance
     * of a lair.
     */
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

    /**
     * Method: Checks hotspot to see if it contains a Base.
     * Inputs: NA
     * Returns: boolean true if it contains a base.  False, otherwise.
     * Description: Method iterates through list of hotspots to check for an instance
     * of a base.
     */
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
