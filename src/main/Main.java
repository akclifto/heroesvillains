
import decorator.DecoratorControl;
import factory.FactoryControl;
import mediator.MediatorControl;

import java.util.concurrent.ThreadLocalRandom;


/**
 * File: Main.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.29
 *
 * <p>Description: Main will initiate each design implementation for the simulation.
 */
public class Main {

    /**
     * Method: Main method to run program simulations.
     * Inputs: args[] : String
     * Returns: void
     * Description: This is the main method to run the program simulations.
     * It will run a factory, decorator and mediator design simulation for
     * heroes and villains.
     */
    public static void main(String[] args) {

        FactoryControl f = new FactoryControl();
        DecoratorControl c = new DecoratorControl();
        MediatorControl m = new MediatorControl();

//        for (int i = 0; i < 100; i++) {
//            System.out.println(ThreadLocalRandom.current().nextInt(1, 4));
//        }
        f.run();
        c.run();
        m.run();
    }
}
