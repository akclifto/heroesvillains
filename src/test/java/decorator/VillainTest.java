package decorator;

import org.junit.Test;

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

        

    }
}