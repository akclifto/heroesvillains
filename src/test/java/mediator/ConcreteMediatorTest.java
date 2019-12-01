package mediator;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

public class ConcreteMediatorTest {

    private ConcreteMediator med;

    @Test
    public void run() {

        MediatorControl mediatorTest = new MediatorControl();
        AtomicBoolean isExecuted = new AtomicBoolean();
        isExecuted.set(false);
        while (!isExecuted.get()) {
            mediatorTest.run();
            isExecuted.set(true);
        }
        assertTrue(isExecuted.get());
    }

    @Test
    public void setGetHero() {

        med = new ConcreteMediator();
        Hero hero1 = new Hero(med, "NewHero");
        med.setHero(hero1);
        assertEquals("NewHero", med.getHero().getName());
    }


    @Test
    public void setGetVillain() {

        med = new ConcreteMediator();
        Villain villian = new Villain(med, "TestVillain");
        med.setVillain(villian);
        assertEquals("TestVillain", med.getVillain().getName());
    }


    @Test
    public void getHeroList() {

        med = new ConcreteMediator();
        Hero hero = new Hero(med, "TestHero");
        med.getHeroList().add(hero);
        assertEquals(1, med.getHeroList().size());

    }

    @Test
    public void getVillainList() {

        med = new ConcreteMediator();
        Villain villain = new Villain(med, "TestVillain");
        med.getVillainList().add(villain);
        assertEquals(1, med.getVillainList().size());
    }

    @Test
    public void sendMessage() {

        med = new ConcreteMediator();
        Hero hero = new Hero(med, "TestHero");
        Villain villain = new Villain(med, "TestVillain");
        med.getHeroList().add(hero);
        med.setHero(hero);
        med.getVillainList().add(villain);
        med.setVillain(villain);
        hero.send(99);
        assertEquals(0, med.getVillainList().size());

        villain =  new Villain(med, "Villain 2");
        med.setVillain(villain);
        med.getVillainList().add(villain);
        villain.send(99);
        assertEquals(0, med.getHeroList().size());

        hero = new Hero(med, "Hero 2");
        med.setHero(hero);
        med.getHeroList().add(hero);
        boolean isDead = false;
        hero.send(1);
        villain.send(1);
        if(hero.isDead() || villain.isDead()) {
            isDead = true;
        }
        assertTrue(isDead);
    }

    @Test
    public void sendMessageElemental() {

        med = new ConcreteMediator();
        boolean isDead = false;
        Hero hero = new Hero(med, "Hero 3");
        Villain villain = new Villain(med, "Villain 3");
        med.setVillain(villain);
        med.setHero(hero);
        med.getHeroList().add(hero);
        med.getVillainList().add(villain);
        hero.send(2);
        villain.send(2);
        if(hero.isDead() || villain.isDead()) {
            isDead = true;
        }
        assertTrue(isDead);
    }

    @Test
    public void initialize() {

        med = new ConcreteMediator();
        med.initialize();
        assertEquals(10, med.getHeroList().size());
        assertEquals(10, med.getVillainList().size());
    }

    @Test
    public void initiateRandom() {

        med = new ConcreteMediator();
        Hero hero = new Hero(med, "Hero 1");
        Villain villain = new Villain(med, "Villain 1");
        med.setVillain(villain);
        med.setHero(hero);
        med.getHeroList().add(hero);
        med.getVillainList().add(villain);

        boolean isDead = false;
        med.initiateRandom();
        if (med.getVillain().isDead() || med.getHero().isDead()) {
            isDead = true;
        }
        assertTrue(isDead);
        boolean listEmpty = false;
        if (med.getVillainList().size() == 0 || med.getHeroList().size() == 0) {
            listEmpty = true;
        }
        assertTrue(listEmpty);

    }

    @Test
    public void newBattle() {

        med = new ConcreteMediator();
        Hero hero = new Hero(med, "Hero 1");
        Villain villain = new Villain(med, "Villain 1");
        med.setVillain(villain);
        med.setHero(hero);
        med.getHeroList().add(hero);
        med.getVillainList().add(villain);
        med.newBattle();
        boolean isDead = false;
        if (med.getVillain().isDead() || med.getHero().isDead()) {
            isDead = true;
        }
        assertTrue(isDead);

        boolean listEmpty = false;
        if (med.getVillainList().size() == 0 || med.getHeroList().size() == 0) {
            listEmpty = true;
        }
        assertTrue(listEmpty);

    }
}