package factory;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VillainLair implements LairBase {

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

    public VillainLair(String name) {
        this.name = name;
        this.pop = 0;
    }

    @Override
    public void setElements() {

        try {
            for (int i = 0; i < elementList.size(); i++) {
                int rand = ThreadLocalRandom.current().nextInt(0, 3);
                elementList.set(i, rand);
            }
        } catch (NullPointerException e){
            System.out.println("Element list is pointing to null.");
            e.printStackTrace();
        }
    }

    @Override
    public void setFire(int num) {

        int temp = fire + num;
        this.fire = temp;
        elementList.set(0, fire);

    }

    @Override
    public void setEarth(int num) {

        int temp = earth + num;
        this.earth = temp;
        elementList.set(1, earth);
    }

    @Override
    public void setWind(int num) {

        int temp = wind + num;
        this.wind = temp;
        elementList.set(2, wind);
    }

    @Override
    public void setIce(int num) {

        int temp = ice + num;
        this.ice = temp;
        elementList.set(3, ice);
    }

    @Override
    public void setShock(int num) {

        int temp = shock + num;
        this.shock = temp;
        elementList.set(4, shock);
    }

    @Override
    public String getName() {
        return null;
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

        int rand = ThreadLocalRandom.current().nextInt(0, 3);
        if (rand == 0) {
            int fire = elementList.get(0) + 2;
            setFire(fire);
        }
    }

    @Override
    public void addWeakness() {

    }
}
