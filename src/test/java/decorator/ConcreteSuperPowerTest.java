package decorator;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

public class ConcreteSuperPowerTest {

    private ConcreteSuperPower conc;

    @Rule
    public ExpectedException exc = ExpectedException.none();

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

        conc = new ConcreteSuperPower();
        conc.createHero("Hero 1");
        conc.createHero("Hero 2");
        List<Integer> eleList = conc.getSpawnedHeroes().get(0).getElementList();
        int ele = eleList.get(3);
        conc.addPower("Hero 1", 3, 4 );
        List<Integer> newList = conc.getSpawnedHeroes().get(0).getElementList();
        System.out.println("Old Ice: " + ele);
        System.out.println("New Ice: " + newList.get(3));
        assertTrue(newList.get(3) > ele);

        conc.spawnVillain("Villain 1");
        conc.spawnVillain("Villain 2");
        List<Integer> villList = conc.getSpawnedVillains().get(1).getElementList();
        int villEle = villList.get(0);
        conc.addPower("Villain 2", 0, 4 );
        List<Integer> newVillEle = conc.getSpawnedVillains().get(1).getElementList();
        System.out.println("Old Fire: " + villEle);
        System.out.println("New Fire: " + newVillEle.get(0));
        assertTrue(newVillEle.get(0) > villEle);

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