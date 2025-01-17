package factory;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class HeroBaseTest {

    private HeroBase base;

    @Rule
    public ExpectedException exc = ExpectedException.none();

    @Test(expected = NullPointerException.class)
    public void setElements() {

        base = new HeroBase();
        base.setName("TestLair");
        assertEquals("TestLair", base.getName());
        base.setElements();
        List<Integer> testList = base.getElementList();
        for (Integer list : testList) {
            System.out.print(list + ", ");
        }
        System.out.println();
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

        base = new HeroBase();
        List<Integer> bonusList = base.getElementList();
        for (Integer list : bonusList) {
            System.out.print(list + ", ");

        }
        System.out.println();
        base.addBonus();
        List<Integer> checkList = base.getElementList();
        for (Integer list : checkList) {
            System.out.print(list + ", ");
        }

        for (int i = 0; i < checkList.size(); i++) {
            if (!checkList.get(i).equals(bonusList.get(i))) {
                assertNotSame(checkList.get(i), bonusList.get(i));
            }
        }
    }

    @Test
    public void addWeakness() {

        base = new HeroBase();
        HeroBase baseTest = new HeroBase();
        baseTest.addWeakness();
        baseTest.addWeakness();
        List<Integer> baseList = base.getElementList();
        for (Integer list : baseList) {
            System.out.print(list + ", ");
        }
        System.out.println();
        base.addWeakness();
        List<Integer> weakList = base.getElementList();
        for (Integer list : weakList) {
            System.out.print(list + ", ");
        }

        for (int i = 0; i < weakList.size(); i++) {
            if (!weakList.get(i).equals(baseList.get(i))) {
                assertNotSame(weakList.get(i), baseList.get(i));
            }
        }
    }

}