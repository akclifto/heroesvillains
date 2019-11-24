package decorator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * File: ConcreteSuper.java
 * Author:  Adam Clifton (akclifto@asu.edu)
 * Date:  2019.11.23
 *
 * <p>Description: This class implements SpawnSuper Interface and creates Heros and Villains
 * without additional powers.
 */
public class ConcreteSuper implements SpawnSuper {

    public ConcreteSuper(){
        //ctor
    }


    @Override
    public void spawnHero(String name) {
    }

    @Override
    public void spawnVillain(String name) {
    }

}
