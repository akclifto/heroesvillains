package decorator;

import java.util.Arrays;
import java.util.List;

public class DecoratorControl {

    /**
     * Method: Runs the decorator design simulation
     * Inputs: NA
     * Returns: void
     * Description: This method will run the factory design.  It will:
     *  - spawn heroes and villains.
     *  - give heroes and villains powers.
     *  - allows heroes and villains to spawn children.
     *  - give chance of random normal person to become a hero.
     *  - create a new bases or lairs if size exceeds 5 dwellers.
     *  - balance villain powers with hero powers.
     */
    public void run() {

        System.out.println("Nothing in the decorator yet!");

        int fire = 4;
        int ice = 2;
        int water = 0;
        int shock = 7;
        List<Integer> elements = Arrays.asList(fire, ice, water, shock);

        System.out.println(elements.get(3).toString());


    }

}
