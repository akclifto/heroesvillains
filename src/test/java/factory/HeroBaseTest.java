package factory;

import main.factory.HeroBase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.List;

import static org.junit.Assert.*;

public class HeroBaseTest {

    private HeroBase base;

    @Rule
    public ExpectedException exc = ExpectedException.none();

    @Test (expected = NullPointerException.class)
    public void setElements() {

        base = new HeroBase();
        base.setElements();
        List<Integer> testList = base.getElementList();
        for (Integer list : testList) {
            System.out.print(list + ", ");
        }
        assertEquals(5, base.getElementList().size());
        base.getElementList().replaceAll(null);
        exc.expect(NullPointerException.class);
        exc.expectMessage("Element list is pointing to null.");
        base.setElements();
        assertThat(base.getElementList().get(0), null);

    }

    @Test
    public void setFire() {

        base = new HeroBase();
        base.setFire(3);
        int ele = base.getElementList().get(0);
        assertEquals(3, ele);
    }

    @Test
    public void setEarth() {

        base = new HeroBase();
        base.setEarth(3);
        int ele = base.getElementList().get(1);
        assertEquals(3, ele);
    }

    @Test
    public void setWind() {

        base = new HeroBase();
        base.setWind(3);
        int ele = base.getElementList().get(2);
        assertEquals(3, ele);
    }

    @Test
    public void setIce() {

        base = new HeroBase();
        base.setIce(3);
        int ele = base.getElementList().get(3);
        assertEquals(3, ele);
    }

    @Test
    public void setShock() {

        base = new HeroBase();
        base.setShock(3);
        int ele = base.getElementList().get(4);
        assertEquals(3, ele);
    }


    @Test
    public void addDweller() {

        base = new HeroBase();
        base.addDweller("D 1");
        base.addDweller("D 2");
        base.addDweller("D 3");
        assertEquals(3, base.getPopulation());
        base.addDweller("D 4");
        base.addDweller("D 5");
        assertEquals(5, base.getDwellerList().size());
        base.addDweller("D 6");
        assertEquals(5, base.getPopulation());

    }

    @Test
    public void removeDweller() {

        base = new HeroBase();
        base = new HeroBase();
        base.addDweller("D 1");
        base.addDweller("D 2");
        base.addDweller("D 3");
        base.addDweller("D 4");
        base.addDweller("D 5");
        base.removeDweller("D 5");
        base.removeDweller("D 4");
        assertEquals(3, base.getPopulation());
        base.removeDweller("Fakename");
        assertEquals(3, base.getPopulation());


    }

    @Test
    public void addBonus() {
    }

    @Test
    public void addWeakness() {
    }

    @Test
    public void isBaseFull() {
    }
}