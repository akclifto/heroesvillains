package decorator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConcreteSuperPowerTest {

    private ConcreteSuperPower conc;


    @Test
    public void getSpawnedHeroes() {

        conc = new ConcreteSuperPower();
        conc.createHero("Hero 1");
        assertEquals(1, conc.getSpawnedHeroes().size());


    }

    @Test
    public void getSpawnedVillains() {
    }

    @Test
    public void createHero() {
    }

    @Test
    public void spawnVillain() {
    }

    @Test
    public void randomCitizenHero() {
    }

    @Test
    public void addPower() {
    }

    @Test
    public void absorbPower() {
    }

    @Test
    public void setBaseElements() {
    }

    @Test
    public void getHero() {
    }

    @Test
    public void getVillain() {
    }
}