import factory.FactoryControl;

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

        f.run();
    }
}