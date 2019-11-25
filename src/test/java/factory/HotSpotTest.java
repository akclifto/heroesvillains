package factory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotSpotTest {

    private HotSpot hotspot = new HotSpot("testSpot");
    private VillainLair lair = new VillainLair();
    private HeroBase base = new HeroBase();


    @Test
    public void addLair() {

        hotspot.addLair(lair);
        List<LairBase> lairs = hotspot.getHotspots();
        assertEquals(lair, lairs.get(0));

        hotspot.addLair(lair);
        lairs = hotspot.getHotspots();
        int size = 1;
        assertEquals(size, lairs.size());

    }

    @Test
    public void addBase() {

        hotspot.addBase(base);
        List<LairBase> bases = hotspot.getHotspots();
        assertEquals(base, bases.get(0));

        hotspot.addBase(base);
        bases = hotspot.getHotspots();
        int size = 1;
        assertEquals(size, bases.size());


    }

    @Test
    public void checkLair() {
    }

    @Test
    public void checkBase() {
    }
}