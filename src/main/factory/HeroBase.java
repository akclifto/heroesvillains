package factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeroBase implements LairBase {

    private String name;
    private int pop;
    private int popMax = 5;
    private int fire;
    private int earth;
    private int wind;
    private int ice;
    private int shock;
    private List<Integer> elementList = Arrays.asList(fire, earth, wind, ice, shock);
    private List<String> dwellerList = new ArrayList<>();


    public HeroBase() {

        pop = 0;

    }

    @Override
    public void setElements() {

    }

    @Override
    public void setFire(int num) {

    }

    @Override
    public void setEarth(int num) {

    }

    @Override
    public void setWind(int num) {

    }

    @Override
    public void setIce(int num) {

    }

    @Override
    public void setShock(int num) {

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {

        try {

            return name;

        } catch (Exception e) {

            System.out.println("Name is null.");
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public int getPopulation() {
        return 0;
    }

    @Override
    public void addDweller(String name) {
        if (pop == popMax) {
            HotSpotFactory f = new HotSpotFactory();
            f.createBase();
        } else {
            dwellerList.add(name);
        }

    }

    @Override
    public void removeDweller(String name) {

    }

    @Override
    public void addBonus() {

    }

    @Override
    public void addWeakness() {

    }
}
