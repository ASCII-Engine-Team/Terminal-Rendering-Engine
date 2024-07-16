package engine;

import game.Game;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;

import java.util.Arrays;

class Run {
    private static boolean debug;
    
    public static void main(String[] args) {
        debug = Boolean.parseBoolean(args[0]);

        final Runnable makeFrame; 
        if (!debug) {
            makeFrame = () -> {
                try {
                    System.out.print(Renderer.getFrame());
                    Game.update();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
        } else {
            makeFrame = () -> {
                try {
                    Renderer.getFrame();
                    Game.update();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            };
        }

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Game.initialize();

        // schedules frames at FPS specified in Constants.java
	    final ScheduledFuture<?> frameHandler = 
            scheduler.scheduleAtFixedRate(makeFrame, 0, 1000 / Constants.FPS, MILLISECONDS);
    }
}