import main.factory.Earth;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EarthTest {


    @Before
    public void setUp() throws Exception {
    }


    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void EarthTest() {
        Earth e = new Earth();
        e.getInstance();
        String s = "test";
        System.out.println("test class");
        assertEquals(s, "test");
    }

}
