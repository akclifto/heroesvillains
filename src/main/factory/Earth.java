package main.factory;

/**
 * File: Earth.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: file to create an instance of the Earth to be simulated
 * for Heroes and Villains. Unimplemented. Using a Singleton design.
 */
public class Earth {

    private static Earth instance;

    /**
     * Method: Gets an instance of the planet Earth.
     * Inputs: NA
     * Returns: instance of Earth object.
     * Description: This is a Singleton implementation of Earth to ensure no more
     * than 1 planet Earth is made.
     */
    public static Earth getEarth() {

        if (instance == null) {
            instance = new Earth();
            System.out.println("Initial instance of Earth has been created.");
        } else {
            System.out.println("Earth has already been created.");
        }
        return instance;
    }

}
