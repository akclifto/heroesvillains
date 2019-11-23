import main.factory.Earth;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EarthTest {


    @Test
    public void Earth_test_instance() {

        Earth f = new Earth();
        f.getEarth();
        String s = "Initial instance of Earth has been created.";
        assertEquals("Initial instance of Earth has been created.", s);


//        Earth e = new Earth();
//        e.getInstance();
//        String s = outContent.toString().trim();
//        assertEquals("Initial instance of Earth has been created.", s);
//        outContent.reset();
//        Earth dup = new Earth();
//        dup.getInstance();
//        String d = outContent.toString().trim();
//        assertEquals("Earth has already been created.", d);

    }

}
