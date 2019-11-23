package factory;

public class Earth {

    private static Earth instance;

    public static Earth getEarth() {

        if (instance == null) {
            instance = new Earth();
            System.out.println("Initial instance of Earth has been created.");
        } else {
            System.out.println("Earth has already been created.");
        }
        return instance;
    }

}
