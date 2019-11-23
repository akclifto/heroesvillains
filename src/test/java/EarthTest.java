import main.factory.Earth;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EarthTest {


    @Test
    public void Earth_test_instance() {

        
        Earth e = new Earth();
        e.getEarth();
        String s = outContent.toString().trim();
        assertEquals("Initial instance of Earth has been created.", s);
        outContent.reset();
        Earth dup = new Earth();
        dup.getEarth();
        String d = outContent.toString().trim();
        assertEquals("Earth has already been created.", d);

    }

}
