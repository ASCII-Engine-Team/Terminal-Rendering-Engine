package engine;

import java.util.ArrayList;

public class Renderer {
    private static ArrayList<Renderable> renderables = new ArrayList<Renderable>();
    
    static Frame getFrame() {
        Frame frame = new Frame();

        for (Renderable renderable : renderables) {
            renderable.renderTo(frame);
        }
        
        return frame;
    }

    public static void addRenderable(Renderable renderable) {
        renderables.add(renderable);
    }
}