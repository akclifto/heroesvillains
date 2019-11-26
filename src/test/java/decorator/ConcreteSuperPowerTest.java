package decorator;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

public class ConcreteSuperPowerTest {

    private ConcreteSuperPower conc;

    @Test
    public void run() {
        DecoratorControl decoratorTest = new DecoratorControl();
        AtomicBoolean isExecuted = new AtomicBoolean();
        isExecuted.set(false);
        while(!isExecuted.get()) {
            decoratorTest.run();
            isExecuted.set(true);
        }
        assertTrue(isExecuted.get());
    }

    @Test
    public void getSpawnedHeroes() {

        conc = new ConcreteSuperPower();
        conc.createHero("Hero 1");
        assertEquals(1, conc.getSpawnedHeroes().size());
    }

    @Test
    public void getSpawnedVillains() {

        conc = new ConcreteSuperPower();
        conc.spawnVillain("Hero 1");
        assertEquals(1, conc.getSpawnedVillains().size());
    }

    @Test
    public void createHero() {

        conc = new ConcreteSuperPower();
        conc.createHero("Hero 1");
        conc.createHero("Hero 2");
        assertEquals(2, conc.getSpawnedHeroes().size());
        assertEquals("Hero 2", conc.getSpawnedHeroes().get(1).getName());
    }

    @Test
    public void spawnVillain() {

        conc = new ConcreteSuperPower();
        conc.spawnVillain("Villain 1");
        conc.spawnVillain("Villain 2");
        assertEquals(2, conc.getSpawnedVillains().size());
        assertEquals("Villain 2", conc.getSpawnedVillains().get(1).getName());
    }

    @Test
    public void randomCitizenHero() {

        int spawned = 0;
        int notSpawned = 0;
        conc = new ConcreteSuperPower();
        for (int i = 0; i < 300; i++) {
            if (conc.randomCitizenHero()) {
                spawned++;
            } else {
                notSpawned++;
            }
        }
        System.out.println("random hero spawn: " + spawned);
        System.out.println("not spawned: " + notSpawned);
        assertTrue(spawned >= 1);
        assertTrue(notSpawned >= 50);
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