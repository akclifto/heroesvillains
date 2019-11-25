package factory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotSpotTest {

    private HotSpot lair = new HotSpot("testSpot");


    @Test
    public void addLair() {

        VillainLair newLair = new VillainLair();
        lair.addLair(newLair);
        List<LairBase> lairs = lair.getHotspots();

        assertEquals(newLair, lairs.get(0));


    }

    @Test
    public void addBase() {
    }

    @Test
    public void checkLair() {
    }

    @Test
    public void checkBase() {
    }
}