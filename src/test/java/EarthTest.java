import factory.Earth;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static junit.framework.TestCase.assertEquals;

public class EarthTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

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
