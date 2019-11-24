package factory;

/**
 * File: LairBase.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: Interface class used as foundation for VillainLair and HeroBase
 * class files.  Since VillainLair and HeroBase classes are almost identical, use
 * of an interface is ideal with the factory design.
 */
public interface LairBase {

    /**
     * Method: Sets elements to each Lair or base.
     * Inputs: num : int
     * Returns: void
     * Description: This method will set random elements to each lair or base created.
     */
    public void setElements();

    /**
     * Method: Sets specific value to fire element.
     * Inputs: num : int
     * Returns: void
     * Description: This method will set a specific value to fire element.
     */
    public void setFire(int num);

    /**
     * Method: Sets specific value to earth element.
     * Inputs: num : int
     * Returns: void
     * Description: This method will set a specific value to earth element.
     */
    public void setEarth(int num);

    /**
     * Method: Sets specific value to wind element.
     * Inputs: num : int
     * Returns: void
     * Description: This method will set a specific value to wind element.
     */
    public void setWind(int num);

    /**
     * Method: Sets specific value to ice element.
     * Inputs: num : int
     * Returns: void
     * Description: This method will set a specific value to ice element.
     */
    public void setIce(int num);

    /**
     * Method: Sets specific value to shock element.
     * Inputs: num : int
     * Returns: void
     * Description: This method will set a specific value to shock element.
     */
    public void setShock(int num);

    /**
     * Method: Sets name for a lair or base.
     * Inputs: name : String
     * Returns: void
     * Description: This method will set a specific name to a lair or base.
     */
    public void setName(String name);

    /**Returns the name of the lair or base. */
    public String getName();

    /**Gets the population of a lair or base. */
    public int getPopulation();

    /**
     * Method: Adds a dweller to a lair or base.
     * Inputs: name: String
     * Returns: void
     * Description: This method will add a hero or villain to their respective hotspots.
     * if the base is full, then a new one will be created first, and the dweller
     * will then be added.
     */
    public void addDweller(String name);

    /**
     * Method: Removes a dweller from a lair or base.
     * Inputs: name : String
     * Returns: void
     * Description: This method will remove a dweller by name from their hotspot.  This
     * assumes the dweller died in combat and will be removed from the game.
     */
    public void removeDweller(String name);

    /**
     * Method: Add a bonus attribute to a lair or base.
     * Inputs: NA
     * Returns: void
     * Description: Each base has a chance of getting a bonus stat added to it
     * upon creation.  This method will add that stat.
     */
    public void addBonus();

    /**
     * Method: Add a weakness attribute to a lair or base.
     * Inputs: NA
     * Returns: void
     * Description: Each base has a chance to receiving a weakened stat upon
     * creation.  This method will add the weakness. 
     */
    public void addWeakness();
}
