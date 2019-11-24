package factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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
        setElements();

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

        this.fire = fire + num;
        elementList.set(0, fire);
    }

    @Override
    public void setEarth(int num) {

        this.earth = earth + num;
        elementList.set(1, earth);
    }

    @Override
    public void setWind(int num) {

        this.wind = wind + num;
        elementList.set(2, wind);
    }

    @Override
    public void setIce(int num) {

        this.ice = ice + num;
        elementList.set(3, ice);
    }

    @Override
    public void setShock(int num) {

        this.shock = shock + num;
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

    public List<String> getDwellerList() {
        return dwellerList;
    }

    public List<Integer> getElementList() {
        return elementList;
    }

    @Override
    public void addDweller(String name) {

        if (pop == popMax) {
            HotSpotFactory f = new HotSpotFactory();
            f.createLair();
        } else {
            dwellerList.add(name);
        }
    }

    @Override
    public void removeDweller(String name) {

        dwellerList.remove(name);
        System.out.println(name + " has been removed from the Base.");
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
        int randWeak = ThreadLocalRandom.current().nextInt(0, 4);

        if (elementList.get(randEle) == 0) {
            System.out.println(elementList.get(randEle) + " is set to zero.");
            System.out.println("No weakness will be applied.");

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
