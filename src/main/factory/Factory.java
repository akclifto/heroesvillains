package factory;

public abstract class Factory {

    /**
     * File: Factory.java
     * Author:  Adam Clifton (akclifto@asu.edu)
     * Date:  2019.11.23
     *
     * <p>Description: Abstract Factory class used for base methods for creating "hotspots",
     * or Lairs and Bases for Villains and Heroes.  This file is used to create/remove a Lair/Base.
     */

    public abstract LairBase createLair();

    public abstract LairBase createBase();

    public abstract void removeLair(LairBase object);

    public abstract void removeBase(LairBase object);



}
