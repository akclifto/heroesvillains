package factory;

import java.util.ArrayList;
import java.util.List;

public class Villain {

    /**This is a placeholder class for villains to be used to implement the factory design method. */
    private String name;
    public List<Villain> vList = new ArrayList<>();

    public Villain(String name) {
        this.name = name;
        vList.add(this);
    }

    public String getName() {
        return name;
    }
}
