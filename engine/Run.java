package engine;

import game.Game;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;

public class Run {
    private static boolean debug;
    
    public static void main(String[] args) {
        debug = Boolean.parseBoolean(args[0]);

        final Runnable makeFrame; 
        if (!debug) {
            makeFrame = () -> {
                Game.update();
                System.out.print(Renderer.getFrame());
            };
        } else {
            makeFrame = () -> {
                Game.update();
                Renderer.getFrame();
            };
        }

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Game.initialize();

        // schedules frames at FPS specified in Constants.java
	    final ScheduledFuture<?> frameHandler = 
            scheduler.scheduleAtFixedRate(makeFrame, 0, 1000 / Constants.FPS, MILLISECONDS);
    }
}