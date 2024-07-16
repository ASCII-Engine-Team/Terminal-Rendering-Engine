package engine;

public class Frame {
    private StringBuilder[] data;

    Frame() {
        StringBuilder blankLine = new StringBuilder(" ".repeat(Constants.SCREEN_WIDTH));
        data = new StringBuilder[Constants.SCREEN_HEIGHT];
        if (data.length != 0) data[0] = blankLine;
        for (int i = 1; i < data.length; i++) {
            data[i] = new StringBuilder(blankLine);
        }
    }

    public void setChixelAt(int x, int y, char chixel) {
        data[y].setCharAt(x, chixel);
    }

    public char getChixelAt(int x, int y) {
        return data[y].charAt(x);
    }

    public String toString() {
        StringBuilder finalFrame = 
            new StringBuilder(
                Constants.SCREEN_WIDTH * Constants.SCREEN_HEIGHT  + Constants.SCREEN_HEIGHT - 1
            );

        for (int i = 0; i < data.length; i++) {
            finalFrame.append(data[i]);
        }

        return finalFrame.toString();
    }
}