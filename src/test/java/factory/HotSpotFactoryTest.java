package factory;

import org.junit.Test;

import static org.junit.Assert.*;

public class HotSpotFactoryTest {

    HotSpotFactory hotspot;

    @Test
    public void getLairs() {

        hotspot = new HotSpotFactory();
        hotspot.initHotspot("TestCity");
        hotspot.createLair();
        hotspot.getLairs();
        assertEquals(1, hotspot.getLairs().size());
    }

    @Test
    public void getBases() {

        hotspot = new HotSpotFactory();
        hotspot.initHotspot("TestCity");
        hotspot.createBase();
        hotspot.getBases();
        assertEquals(1, hotspot.getBases().size());

    }

    @Test
    public void initHotspot() {

        

    }

    @Test
    public void createHotspot() {
    }

    @Test
    public void createBase() {
    }

    @Test
    public void createLair() {
    }

    @Test
    public void removeLair() {
    }

    @Test
    public void removeBase() {
    }
}