package factory;

public interface LairBase {

    public void setElements();

    public void setFire(int num);

    public void setEarth(int num);

    public void setWind(int num);

    public void setIce(int num);

    public void setShock(int num);

    public void setName(String name);

    public String getName();

    public int getPopulation();

    public void addDweller(String name);

    public void removeDweller(String name);

    public void addBonus();

    public void addWeakness();
}
