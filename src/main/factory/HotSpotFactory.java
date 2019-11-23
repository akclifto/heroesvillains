package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HotSpotFactory extends Factory {

    private VillainLair villainLair;
    private HeroBase heroBase;
    private List<Object> lairs = new ArrayList<>();
    private List<Object> bases = new ArrayList<>();

    public HotSpotFactory() {
        //ctor
    }


    @Override
    public LairBase createLair(boolean isHero) {

        if (isHero) {
            heroBase = new HeroBase();
            //TODO set name of base
            //TODO set pop to zero
            bases.add(heroBase);
            System.out.println("A new hero base has been added to the planet.");

        } else {
            villainLair = new VillainLair();
            //TODO set name of lair
            //TODO set pop to zero
            lairs.add(villainLair);
            System.out.println("A new villain lair has been added to the planet.");
        }

        return null;
    }

    @Override
    public void addBonus() {

        int rand = ThreadLocalRandom.current().nextInt(0, 6);
        if (rand == 0) {

        }
        System.out.println();

    }

    @Override
    public void addWeakness() {

    }
}
