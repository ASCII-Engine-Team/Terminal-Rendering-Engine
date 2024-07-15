package engine;

import game.Game;

import static java.util.concurrent.TimeUnit.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;

public class Run {
    public static void main(String[] args) {
		final int millisecondPause = 1000 / Constants.FPS;

        final Runnable makeFrame = () -> {
            Game.update();
			System.out.print(Renderer.getFrame());
		};

        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Game.initialize();

        // schedules a frame every millisecondPause
	    final ScheduledFuture<?> frameHandler = 
            scheduler.scheduleAtFixedRate(makeFrame, 0, millisecondPause, MILLISECONDS);
    }
}