package engine;

public class Constants {
	public static final int SCREEN_WIDTH = 183;
	public static final int SCREEN_HEIGHT = 45;

	public static final double Y_STRETCH = 2.15;

	public static final double PLANE_WIDTH = (double)SCREEN_WIDTH;
	public static final double PLANE_HEIGHT = Y_STRETCH * SCREEN_HEIGHT;
	
	public static final int FPS = 30;
	public static final double SECONDS_PER_FRAME = 1.0 / FPS;
}