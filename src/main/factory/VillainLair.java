package factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VillainLair implements LairBase {

    private String name;
    private int fire = 0;
    private int earth = 0;
    private int wind = 0;
    private int ice = 0;
    private int shock = 0;
    private List<Integer> elementList = Arrays.asList(fire, earth, wind, ice, shock);
    private List<String> dwellerList = new ArrayList<>();

    public VillainLair() {

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
        return dwellerList.size();
    }

    @Override
    public void addDweller(String name) {

        if (dwellerList.size() == 5) {
            System.out.println("A new Lair is being created.");
            HotSpotFactory f = new HotSpotFactory();
            f.createLair();
            addDweller(name);
        } else {
            System.out.print(name + " has been added to the Lair. ");
            System.out.println("The dark grip of evil expands!");
            dwellerList.add(name);
        }
    }

    @Override
    public void removeDweller(String name) {

        if (!dwellerList.contains(name)) {
            System.out.println("The following name does not appear in the Base: " + name);
        } else {
            dwellerList.remove(name);
            System.out.println(name + " has been removed from the Lair.");
        }
        if (dwellerList.size() == 0) {
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
