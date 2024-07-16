package engine;

class Renderer {
    static StringBuilder getFrame() {
        StringBuilder frame = new StringBuilder();

        for (int y = 0; y < Constants.SCREEN_HEIGHT; y++) {
            for (int x = 0; x < Constants.SCREEN_WIDTH; x++) {
                screen.append('■');
            }

            // ends current line
            frame.append('\n');
        }

        // removes last newline
        frame.setLength(frame.length() - 1);
        
        return frame;
    }
}