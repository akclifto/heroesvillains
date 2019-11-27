package decorator;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class HeroTest {

    private Hero hero;

    @Test
    public void setName() {

        hero = new Hero();
        hero.setName("TestHero");
        assertEquals("TestHero", hero.getName());
    }

    @Test
    public void getElementList() {

        hero = new Hero("TestHero");
        assertEquals(5, hero.getElementList().size());
        assertNotNull(hero.getElementList());

        hero = new Hero();
        hero.setName("Hero 2");
        hero.setBaseElements(hero.getElementList(), 0, 6);
        assertNotNull(hero.getElementList());
    }

    @Test
    public void addToHeroList() {

        hero = new Hero();
        hero.setName("TestHero");
        hero.addToHeroList(hero);
        assertEquals(1, hero.getHeroList().size());
        assertEquals("TestHero", hero.getHeroList().get(0).getName());

    }

    @Test
    public void replaceElementList() {

        hero = new Hero("TestHero");
        Hero hero1 = new Hero("Hero1");
        List<Integer> newList = hero1.getElementList();
        hero.replaceElementList(newList);
        assertEquals(hero.getElementList(), hero1.getElementList());
        assertEquals(hero.getElementList(), newList);


    }
}