package mediator;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class VillainTest {

    private Villain villain;
    private ConcreteMediator med;


    @Test
    public void setBaseElements() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        villain.setBaseElements(villain.getElementList());
        boolean notZero = false;
        for (Integer item : villain.getElementList()) {
            if (item > 0) {
                notZero = true;
                break;
            }
        }
        assertTrue(notZero);
    }

    @Test(expected = NullPointerException.class)
    public void processMove() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        villain.processMove(0);
        assertEquals(100, villain.getHealth());
        villain.processMove(1);
        assertNotEquals(100, villain.getHealth());
        villain.processMove(2);
        assertNotEquals(100, villain.getHealth());

        villain.processMove(3);
    }

    @Test
    public void physicalAttack() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        for (int i = 0; i < 10; i++) {
            villain.processMove(1);
        }
        assertNotEquals(100, villain.getHealth());
    }

    @Test
    public void elementalAttack() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        for (int i = 0; i < 10; i++) {
            villain.processMove(2);
        }
        assertNotEquals(100, villain.getHealth());
    }


    @Test
    public void setRandomMove() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        boolean moveSet = false;

        int move = villain.setRandomMove();
        if (move == 1 || move == 2) {
            moveSet = true;
        }
        assertTrue(moveSet);
    }

    @Test
    public void deductDamage() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        assertEquals(100, villain.getHealth());
        villain.processMove(1);
        assertNotEquals(100, villain.getHealth());

        villain = new Villain(med, "Villain 2");
        assertEquals(100, villain.getHealth());
        villain.processMove(2);
        assertNotEquals(100, villain.getHealth());
    }

    @Test
    public void criticalHitChance() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        boolean crit = false;
        for (int i = 0; i < 100; i++) {
            boolean hold = villain.criticalHitChance();
            if (hold) {
                crit = true;
            }
        }
        assertTrue(crit);
    }

    @Test
    public void receive() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        List<Integer> oldList = villain.getElementList();
        villain.setBaseElements(villain.getElementList());

        villain.receive(0, true, false);
        List<Integer> newList = villain.getElementList();

        for (int i = 0; i < villain.getElementList().size(); i++) {
            if (!newList.get(i).equals(oldList.get(i))) {
                assertNotSame(newList.get(i), oldList.get(i));
            }
        }

        List<Integer> oldEleList = villain.getElementList();
        villain.receive(0, false, true);
        assertTrue(villain.isResting());
        List<Integer> newEleList = villain.getElementList();
        for (int i = 0; i < villain.getElementList().size(); i++) {
            if (!newEleList.get(i).equals(oldEleList.get(i))) {
                assertNotSame(newEleList.get(i), oldEleList.get(i));
            }
        }
    }

    @Test
    public void send() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        boolean sentMove = false;
        villain.setVillainMove(villain.setRandomMove());
        villain.send(villain.getMove());
        if (villain.getMove() == 1 || villain.getMove() == 2) {
            sentMove = true;
        }
        assertTrue(sentMove);
    }

    @Test
    public void isResting() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        villain.setIsResting(true);
        assertTrue(villain.isResting());

        villain.setResting();
        assertFalse(villain.isResting());

    }

    @Test
    public void isDead() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        villain.setHealth(0);
        assertTrue(villain.isDead());
    }

    @Test
    public void consumePower() {

        med = new ConcreteMediator();
        villain = new Villain(med, "Villain 1");
        boolean moreStrength = false;
        boolean moreEle = false;

        for (int i = 0; i < 100; i++) {
            villain.consumePower();
            if (villain.getStrength() > 11) {
                moreStrength = true;
            }
            if (villain.getElementList().get(0) > 15) {
                moreEle = true;
            }
            if (villain.getElementList().get(1) > 15) {
                moreEle = true;
            }
            if (villain.getElementList().get(2) > 15) {
                moreEle = true;
            }
            if (villain.getElementList().get(3) > 15) {
                moreEle = true;
            }
            if (villain.getElementList().get(4) > 15) {
                moreEle = true;
            }
        }
        assertTrue(moreStrength);
        assertTrue(moreEle);
    }
}