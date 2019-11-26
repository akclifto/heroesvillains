package decorator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class VillainTest {

    private Villain villain;

    @Test
    public void getName() {

        villain = new Villain("TestVillain");
        assertEquals("TestVillain", villain.getName());
    }

    @Test
    public void getElementList() {

        villain = new Villain("TestVillain");
        assertEquals(5, villain.getElementList().size());
        assertNotNull(villain.getElementList());
    }

    @Test
    public void replaceElementList() {

        villain = new Villain("TestVillain");
        Villain vill1 = new Villain("Vill1");
        List<Integer> newList = vill1.getElementList();
        villain.replaceElementList(newList);
        assertEquals(villain.getElementList(), vill1.getElementList());
        assertEquals(villain.getElementList(), newList);
    }
}