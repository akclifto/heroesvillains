package factory;

import java.util.concurrent.ThreadLocalRandom;

public class HotSpotFactory extends Factory {

    private VillainLair villainLair;
    private HeroBase heroBase;


    public HotSpotFactory() {
        //ctor
    }


    @Override
    public LairBase createLair(boolean isHero) {

        if (isHero) {
            heroBase = new HeroBase();
            //TODO set name of base

        } else {
            villainLair = new VillainLair();
            //TODO set name of lair
        }

        return null;
    }

    @Override
    public void addBonus() {

        int rand = ThreadLocalRandom.current().nextInt(0, 7);
        System.out.println();

    }

    @Override
    public void addWeakness() {

    }
}
