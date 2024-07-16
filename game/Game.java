package game;

import engine.*;

public class Game {
    private static Text message;
    
    private static double messageChangeX = 13.0;
    private static double messageChangeY = 10.0;
    private static double messageX = 0.0;
    private static double messageY = 0.0;
    
    public static void initialize() {
        message = new Text(messageX, messageY, 50, "Hello, Worldhjsdavchjsdhabchjdsabchvdsahgcvhgsavdhcvhgasvchgasvhg");
        Renderer.addRenderable(message);
    }

    public static void update() {
        if (true) {
            messageX += messageChangeX * Constants.SECONDS_PER_FRAME;
            messageY += messageChangeY * Constants.SECONDS_PER_FRAME;
            message.setTopLeftPosition(messageX, messageY);
        }
    }
}