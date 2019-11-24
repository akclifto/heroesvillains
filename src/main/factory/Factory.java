package factory;

/**
 * File: Factory.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Abstract Factory class used for base methods for creating "hotspots",
 * or Lairs and Bases for Villains and Heroes.  This file is used to create/remove a Lair/Base.
 */
public abstract class Factory {

    /**
     * Method: Creates a new lair in the simulation
     * Inputs: NA
     * Returns: new Lair.
     * Description: This method add a new lair to the simulation, then puts
     * it in a list to track all lairs in the game.
     */
    public abstract LairBase createLair();

    /**
     * Method: Creates a new base in the simulation
     * Inputs: NA
     * Returns: new base.
     * Description: This method add a new base to the simulation, then puts
     * it in a list to track all bases in the game.
     */
    public abstract LairBase createBase();

    /**
     * Method: Removes a lair from the game.
     * Inputs: object : LairBase
     * Returns: void
     * Description: This method add a new base to the simulation, then puts
     * it in a list to track all bases in the game.
     */
    public abstract void removeLair(LairBase object);

    /**
     * Method: Sets elements to each Lair or base.
     * Inputs: object : LairBase
     * Returns: void
     * Description: This method will set random elements to each lair or base created.
     */
    public abstract void removeBase(LairBase object);



}
