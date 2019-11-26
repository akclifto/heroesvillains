package factory;

import org.junit.Test;

import static org.junit.Assert.*;

public class HotSpotFactoryTest {

    HotSpotFactory factory;

    @Test
    public void getLairs() {

        factory = new HotSpotFactory();
        factory.initHotspot("TestCity");
        factory.createLair();
        assertEquals(1, factory.getLairs().size());
    }

    @Test
    public void getBases() {

        factory = new HotSpotFactory();
        factory.initHotspot("TestCity");
        factory.createBase();
        assertEquals(1, factory.getBases().size());

    }

    @Test
    public void initHotspot() {

        factory = new HotSpotFactory();
        factory.initHotspot("TestCity");
        assertEquals("TestCity",
                factory.getHotspotList().get(0).getName());

    }

    @Test
    public void createHotspot() {

        factory = new HotSpotFactory();
        factory.createHotspot("TestCity");
        assertEquals("TestCity",
                factory.getHotspotList().get(0).getName());
        factory.createHotspot("Test 1");
        assertEquals(2, factory.getHotspotList().size());
        factory.createHotspot("Test 2");
        assertNotEquals(3, factory.getHotspotList().size());


    }

    @Test
    public void createBase() {

        HeroBase base = new HeroBase();
        factory = new HotSpotFactory();
        factory.initHotspot("TestCity");
        factory.createBase();
        assertEquals(1, factory.getBases().size());;
        base.addDweller("H 1");
        base.addDweller("H 2");
        base.addDweller("H 3");
        base.addDweller("H 4");
        base.addDweller("H 5");
        base.addDweller("H 6");
        factory.createBase();
        assertEquals(2, factory.getBases().size());



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