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


    }

    @Test
    public void initialize() {
    }

    @Test
    public void initiateRandom() {
    }

    @Test
    public void newBattle() {
    }
}