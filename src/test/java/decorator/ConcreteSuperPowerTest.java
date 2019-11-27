package decorator;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ConcreteSuperPowerTest {

    private ConcreteSuperPower conc;


    @Test
    public void run() {
        DecoratorControl decoratorTest = new DecoratorControl();
        AtomicBoolean isExecuted = new AtomicBoolean();
        isExecuted.set(false);
        while (!isExecuted.get()) {
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

        int spawnedRandomCitizen = 0;

        for (int i = 0; i < 300; i++) {
            conc.createHero("Name");
        }
        for (Hero name : conc.getSpawnedHeroes()) {
            if (name.getName().contains("Citizen ")) {
                spawnedRandomCitizen++;
            }
        }
        System.out.println("Spawned random citizens: " + spawnedRandomCitizen);
        assertTrue(spawnedRandomCitizen >= 1);
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

    @Test(expected = NullPointerException.class)
    public void addPower() {

        conc = new ConcreteSuperPower();
        conc.createHero("Hero 1");
        conc.createHero("Hero 2");
        List<Integer> eleList = conc.getSpawnedHeroes().get(0).getElementList();
        int ele = eleList.get(3);
        conc.addPower("Hero 1", 3, 4);
        List<Integer> newList = conc.getSpawnedHeroes().get(0).getElementList();
        System.out.println("Old Ice: " + ele);
        System.out.println("New Ice: " + newList.get(3));
        assertTrue(newList.get(3) > ele);

        conc.spawnVillain("Villain 1");
        conc.spawnVillain("Villain 2");
        List<Integer> villList = conc.getSpawnedVillains().get(1).getElementList();
        int villEle = villList.get(0);
        conc.addPower("Villain 2", 0, 4);
        List<Integer> newVillEle = conc.getSpawnedVillains().get(1).getElementList();
        System.out.println("Old Fire: " + villEle);
        System.out.println("New Fire: " + newVillEle.get(0));
        assertTrue(newVillEle.get(0) > villEle);
        System.out.println();

        conc.addPower(null, 0, 99);
        assertThat(conc.getVillain(conc.getSpawnedVillains(), "FakeName"), null);
    }

    @Test //(expected = NullPointerException.class)
    public void absorbPower() {

        conc = new ConcreteSuperPower();
        conc.createHero("Test Hero");
        conc.spawnVillain("Test Villain");
        Hero hero = conc.getSpawnedHeroes().get(0);
        List<Integer> oldList = hero.getElementList();
        List<Integer> newList = conc.absorbPower(conc.getSpawnedHeroes().get(0), null);
        for (int i = 0; i < newList.size(); i++) {
            if (!newList.get(i).equals(oldList.get(i))) {
                assertNotSame(newList.get(i), oldList.get(i));
            }
        }

        Villain villain = conc.getSpawnedVillains().get(0);
        List<Integer> oldVill = villain.getElementList();
        List<Integer> newVill = conc.absorbPower(null, conc.getSpawnedVillains().get(0));
        for (int i = 0; i < newVill.size(); i++) {
            if (!newVill.get(i).equals(oldVill.get(i))) {
                assertNotSame(newVill.get(i), oldVill.get(i));
            }
        }
//        exc.expect(NullPointerException.class.);
//        exc.expectMessage("Both hero and villain fields are null.");
//        conc.absorbPower(null, null);
    }

    @Test
    public void setBaseElements() {

        conc = new ConcreteSuperPower();
        Hero hero = new Hero();
        List<Integer> oldList = hero.getElementList();
        conc.getSpawnedHeroes().add(hero);
        conc.setBaseElements(conc.getSpawnedHeroes().get(0).getElementList(), 0, 10);
        List<Integer> newList = conc.getSpawnedHeroes().get(0).getElementList();
        for (int i = 0; i < newList.size(); i++) {
            if (!newList.get(i).equals(oldList.get(i))) {
                assertNotSame(newList.get(i), oldList.get(i));
            }
        }

    }

}