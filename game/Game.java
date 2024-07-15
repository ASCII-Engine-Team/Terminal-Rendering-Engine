package game;

public class Game {
    private static int updateNum = 0;

    public static void initialize() {
        System.out.println("Hello World");
    }

    public static void update() {
        updateNum += 1;
        System.out.println("Update " + updateNum);
    }
}