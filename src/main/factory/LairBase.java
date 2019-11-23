package factory;

public interface LairBase {

    int fire = 2;
    int earth = 2;
    int wind = 2;
    int ice = 2;
    int shock = 2;

    public void addDweller(String name);

    public void removeDweller(String name);
    
}
