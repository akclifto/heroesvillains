package factory;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.*;

public class VillainLairTest {

    private VillainLair lair;

    @Rule
    public ExpectedException exc = ExpectedException.none();

    @Test (expected = NullPointerException.class)
    public void setElements() {

        lair = new VillainLair();
        lair.setName("TestLair");
        assertEquals("TestLair", lair.getName());
        lair.setElements();
        List<Integer> testList = lair.getElementList();
        for (Integer list : testList) {
            System.out.print(list + ", ");
        }
        System.out.println();
        assertEquals(5, lair.getElementList().size());
        lair.getElementList().replaceAll(null);
        exc.expect(NullPointerException.class);
        exc.expectMessage("Element list is pointing to null.");
        lair.setElements();
        assertThat(lair.getElementList().get(0), null);

    }

    @Test
    public void setFire() {

        lair = new VillainLair();
        lair.setFire(3);
        int ele = lair.getElementList().get(0);
        assertEquals(3, ele);
    }

    @Test
    public void setEarth() {

        lair = new VillainLair();
        lair.setEarth(3);
        int ele = lair.getElementList().get(1);
        assertEquals(3, ele);
    }

    @Test
    public void setWind() {

        lair = new VillainLair();
        lair.setWind(3);
        int ele = lair.getElementList().get(2);
        assertEquals(3, ele);
    }

    @Test
    public void setIce() {

        lair = new VillainLair();
        lair.setIce(3);
        int ele = lair.getElementList().get(3);
        assertEquals(3, ele);
    }

    @Test
    public void setShock() {

        lair = new VillainLair();
        lair.setShock(3);
        int ele = lair.getElementList().get(4);
        assertEquals(3, ele);
    }


    @Test
    public void addDweller() {

        lair = new VillainLair();
        lair.addDweller("D 1");
        lair.addDweller("D 2");
        lair.addDweller("D 3");
        assertEquals(3, lair.getPopulation());
        lair.addDweller("D 4");
        lair.addDweller("D 5");
        assertEquals(5, lair.getDwellerList().size());
        lair.addDweller("D 6");
        assertEquals(5, lair.getPopulation());

    }

    @Test
    public void removeDweller() {

        lair = new VillainLair();
        lair.addDweller("D 1");
        lair.addDweller("D 2");
        lair.addDweller("D 3");
        lair.addDweller("D 4");
        lair.addDweller("D 5");
        lair.removeDweller("D 5");
        lair.removeDweller("D 4");
        assertEquals(3, lair.getPopulation());
        lair.removeDweller("Fakename");
        assertEquals(3, lair.getPopulation());


    }

    @Test
    public void addBonus() {

        lair = new VillainLair();
        List<Integer> bonusList = lair.getElementList();
        for (Integer list : bonusList) {
            System.out.print(list + ", ");

        }
        System.out.println();
        lair.addBonus();
        List<Integer> checkList = lair.getElementList();
        for (Integer list : checkList) {
            System.out.print(list + ", ");
        }

        for (int i = 0; i < checkList.size(); i++) {
            if (checkList.get(i) != bonusList.get(i)){
                assertNotSame(checkList.get(i), bonusList.get(i));
            }
        }
    }

    @Test
    public void addWeakness() {

        lair = new VillainLair();
        List<Integer> lairList = lair.getElementList();
        for (Integer list : lairList) {
            System.out.print(list + ", ");
        }
        System.out.println();
        lair.addWeakness();
        List<Integer> weakList = lair.getElementList();
        for (Integer list : weakList) {
            System.out.print(list + ", ");
        }

        for (int i = 0; i < weakList.size(); i++) {
            if (weakList.get(i) != lairList.get(i)){
                assertNotSame(weakList.get(i), lairList.get(i));
            }
        }
    }
}