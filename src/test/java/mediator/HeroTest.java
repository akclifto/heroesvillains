package mediator;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;
    private ConcreteMediator med;


    @Test
    public void setBaseElements() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        hero.setBaseElements(hero.getElementList());
        boolean notZero = false;
        for (Integer item : hero.getElementList()) {
            if (item > 0) {
                notZero = true;
            }
        }
        assertTrue(notZero);
    }

    @Test (expected = NullPointerException.class)
    public void processMove() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        hero.processMove(0);
        assertEquals(100, hero.getHealth());
        hero.processMove(1);
        assertNotEquals(100, hero.getHealth());
        hero.processMove(2);
        assertNotEquals(100, hero.getHealth());

        hero.processMove(3);
    }

    @Test
    public void physicalAttack() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        for(int i = 0; i < 10; i++) {
            hero.processMove(1);
        }
        assertNotEquals(100, hero.getHealth());
    }

    @Test
    public void ElementalAttack() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        for(int i = 0; i < 10; i++) {
            hero.processMove(2);
        }
        assertNotEquals(100, hero.getHealth());
    }


    @Test
    public void setRandomMove() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        boolean moveSet = false;

        int move = hero.setRandomMove();
        if (move == 1 || move == 2) {
            moveSet = true;
        }
        assertTrue(moveSet);
    }

    @Test
    public void deductDamage() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        assertEquals(100, hero.getHealth());
        hero.processMove(1);
        assertNotEquals(100, hero.getHealth());

        hero = new Hero(med, "Hero 2");
        assertEquals(100, hero.getHealth());
        hero.processMove(2);
        assertNotEquals(100, hero.getHealth());
    }

    @Test
    public void criticalHitChance() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        boolean crit = false;
        for (int i = 0; i < 100; i++) {
            boolean hold = hero.criticalHitChance();
            if (hold) {
                crit = true;
            }
        }
        assertTrue(crit);
    }

    @Test
    public void receive() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        List<Integer> oldList = hero.getElementList();
        hero.setBaseElements(hero.getElementList());

        hero.receive(0, true, false);
        List<Integer> newList = hero.getElementList();

        for (int i = 0 ; i < hero.getElementList().size(); i++) {
            if (!newList.get(i).equals(oldList.get(i))) {
                assertNotSame(newList.get(i),oldList.get(i));
            }
        }

        List<Integer> oldEleList = hero.getElementList();
        hero.receive(0, false, true);
        assertTrue(hero.isResting());
        List<Integer> newEleList = hero.getElementList();
        for (int i = 0 ; i < hero.getElementList().size(); i++) {
            if (!newEleList.get(i).equals(oldEleList.get(i))) {
                assertNotSame(newEleList.get(i),oldEleList.get(i));
            }
        }
    }

    @Test
    public void send() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        boolean sentMove = false;
        hero.setHeroMove(hero.setRandomMove());
        hero.send(hero.getMove());
        if (hero.getMove() == 1 || hero.getMove()== 2) {
            sentMove = true;
        }
        assertTrue(sentMove);
    }

    @Test
    public void isResting() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        hero.setIsResting(true);
        assertTrue(hero.isResting());

        hero.setResting();
        assertFalse(hero.isResting());

    }

    @Test
    public void isDead() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        hero.setHealth(0);
        assertTrue(hero.isDead());
    }

    @Test
    public void consumePower() {

        med = new ConcreteMediator();
        hero = new Hero(med, "Hero 1");
        boolean moreStrength = false;
        boolean moreEle = false;

        for (int i = 0; i < 100; i++) {
            hero.consumePower();
            if(hero.getStrength() > 11) {
                moreStrength = true;
            }
            if (hero.getElementList().get(0) > 15) {
                moreEle = true;
            }
            if (hero.getElementList().get(1) > 15) {
                moreEle = true;
            }
            if (hero.getElementList().get(2) > 15) {
                moreEle = true;
            }
            if (hero.getElementList().get(3) > 15) {
                moreEle = true;
            }
            if (hero.getElementList().get(4) > 15) {
                moreEle = true;
            }
        }
        assertTrue(moreStrength);
        assertTrue(moreEle);
    }
}
