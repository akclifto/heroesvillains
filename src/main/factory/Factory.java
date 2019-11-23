package factory;

public abstract class Factory {

    /**
     * File: Factory.java
     * Author:  Adam Clifton (akclifto@asu.edu)
     * Date:  2019.11.23
     * <p>
     * Description: Abstract Factory class used for base methods for creating "hotspots", or Lairs and Bases for Villains
     * and Heroes.  This file is used to create a Lair/Base and add a Bonus attribute to it.
     */

    public abstract LairBase createLair(boolean isHero);
    public abstract void addBonus();
    public abstract void addWeakness();

}
