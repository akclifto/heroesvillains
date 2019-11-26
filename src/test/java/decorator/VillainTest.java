package decorator;

import org.junit.Test;

import java.util.ArrayList;
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
        villain.getElementList();
        assertEquals(5, villain.getElementList().size());
        assertTrue(villain.getElementList() != null);

    }

    @Test
    public void replaceElementList() {

        villain = new Villain("TestVillain");
        List<Integer> checkList = villain.getElementList();
        Villain vill1 = new Villain("Vill1");
        List<Integer> newList = vill1.getElementList();
        villain.replaceElementList(newList);
        assertEquals(villain.getElementList(), vill1.getElementList());

    }
}