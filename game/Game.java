package game;

import engine.*;

public class Game {
    private static Text message;
    
    private static double messageChangeX = 20.0;
    private static double messageChangeY = 10.0;
    private static double messageX = 0.0;
    private static double messageY = 0.0;
    
    public static void initialize() {
        message = new Text(messageX, messageY, 50, "Hello, World!");
        Renderer.addRenderable(message);
    }

    public static void update() {
        if (true) {
            messageX += messageChangeX * Constants.SECONDS_PER_FRAME;
            messageY += messageChangeY * Constants.SECONDS_PER_FRAME;
            message.setTopLeftPosition(messageX, messageY);
            
            if (messageX < 0) {
                messageX = 0;
                messageChangeX = -messageChangeX;
            } else if (messageX >= Constants.PLANE_WIDTH - message.getWidth()) {
                messageX = Constants.PLANE_WIDTH - message.getWidth();
                messageChangeX = -messageChangeX;
            }

            if (messageY <= 0) {
                messageY = 0;
                messageChangeY = -messageChangeY;
            } else if (messageY >= Constants.PLANE_HEIGHT- message.getHeight()) {
                messageY = Constants.PLANE_HEIGHT - message.getHeight();
                messageChangeY = -messageChangeY;
            }
        }
    }
}