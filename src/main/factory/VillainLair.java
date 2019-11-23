package factory;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VillainLair implements LairBase {

    private String name;
    private int pop = 0;
    private int popMax = 5;
    private int fire;
    private int earth;
    private int wind;
    private int ice;
    private int shock;
    private List<Integer> elementList = Arrays.asList(fire, earth, wind, ice, shock);
    private List<String> dwellerList = new ArrayList<>();

    public VillainLair() {
        this.pop = 0;
    }

    @Override
    public void setElements() {

        try {
            for (int i = 0; i < elementList.size(); i++) {
                int rand = ThreadLocalRandom.current().nextInt(0, 3);
                elementList.set(i, rand);
            }
        } catch (NullPointerException e) {
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

        dwellerList.remove(name);
        System.out.println(name + " has been removed from the Lair.");
        pop--;
        if (pop <= 0) {
            HotSpotFactory f = new HotSpotFactory();
            f.removeLair(this);
        }

    }

    @Override
    public void addBonus() {

        int randEle = ThreadLocalRandom.current().nextInt(0, 6);
        int randBonus = ThreadLocalRandom.current().nextInt(0, 4);
        elementList.set(randEle, randBonus);

    }

    @Override
    public void addWeakness() {

        int randEle = ThreadLocalRandom.current().nextInt(0, 6);
        int randWeak = ThreadLocalRandom.current().nextInt(0, 3);

        if (elementList.get(randEle) == 0) {
            System.out.println("No weakness applied.");

        } else {

            int temp = elementList.get(randEle) - randWeak;
            if (temp <= 0) {
                temp = 0;
                System.out.println(elementList.get(randEle) + " has been set to " + temp);
                elementList.set(randEle, temp);
            } else {
                elementList.set(randEle, temp);
                System.out.println(elementList.get(randEle) + " has been set to " + temp);
            }

        }


    }
}
