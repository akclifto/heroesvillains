package factory;

import main.factory.HeroBase;
import main.factory.HotSpot;
import main.factory.LairBase;
import main.factory.VillainLair;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HotSpotTest {

    private HotSpot hotspot = new HotSpot("testSpot");
    private VillainLair lair = new VillainLair();
    private HeroBase base = new HeroBase();


    @Test
    public void addLairAndCheckLair() {

        hotspot.addLair(lair);
        List<LairBase> lairs = hotspot.getHotspots();
        assertEquals(lair, lairs.get(0));
        String s = "testSpot";
        assertEquals(s, hotspot.getName());
        hotspot.addLair(lair);
        lairs = hotspot.getHotspots();
        int size = 1;
        assertEquals(size, lairs.size());

    }

    @Test
    public void addBaseAndCheckBase() {

        hotspot.addBase(base);
        List<LairBase> bases = hotspot.getHotspots();
        assertEquals(base, bases.get(0));

        hotspot.addBase(base);
        bases = hotspot.getHotspots();
        int size = 1;
        assertEquals(size, bases.size());
    }

}