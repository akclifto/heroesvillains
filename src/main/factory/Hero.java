package factory;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    /**This is a placeholder class for heroes to be used to implement the factory design method. */
    private String name;
    public List<Hero> hList = new ArrayList<>();

    public Hero(String name) {
        this.name = name;
        hList.add(this);
    }

    public String getName() {
        return name;
    }


}
