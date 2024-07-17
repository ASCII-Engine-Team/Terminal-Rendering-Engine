package engine;

public class Text implements Renderable {
    private StringBuilder content;
    
    private double topLeftX;
    private double topLeftY;
    
    private int maxWidth;

    private int length;
    private double width;
    private double height; // byproduct of maxWidth

    public Text(double topLeftX, double topLeftY, int maxWidth) {
        content = new StringBuilder();
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.maxWidth = maxWidth;
        
        length = 0;
        width = 0;
        height = 0;
    }

    public Text(double topLeftX, double topLeftY, int maxWidth, int initialSize) {
        content = new StringBuilder(initialSize);
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.maxWidth = maxWidth;
        
        length = 0;
        width = 0;
        height = 0;
    }

    public Text(double topLeftX, double topLeftY, int maxWidth, String initialContent) {
        content = new StringBuilder(initialContent);
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.maxWidth = maxWidth;
        
        length = initialContent.length();
        width = length < maxWidth ? length : maxWidth;
        height = Constants.Y_STRETCH * length / width;
    }

    public int length() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void append(char c) {
        content.append(c);
        length = content.length();
        width = length < maxWidth ? length : maxWidth;
        height = Constants.Y_STRETCH * length / width;
    }

    public void append(String str) {
        content.append(str);
        length = content.length();
        width = length < maxWidth ? length : maxWidth;
        height = Constants.Y_STRETCH * length / width;
    }

    public void append(StringBuilder sb) {
        content.append(sb);
        length = content.length();
        width = length < maxWidth ? length : maxWidth;
        height = Constants.Y_STRETCH * length / width;
    }

    public void setLength(int newLength) {
        content.setLength(newLength);
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public void resetContent() {
        content = new StringBuilder();
    }

    public void resetContent(int initialSize) {
        content = new StringBuilder(initialSize);
    }

    public void resetContent(String content) {
        this.content = new StringBuilder(content);
    }

    public void setTopLeftPosition(double x, double y) {
        topLeftX = x;
        topLeftY = y;
    }

    public void renderTo(Frame frame) {
        int startX = (int)topLeftX;
        int startY = (int)(topLeftY / Constants.Y_STRETCH);
        
        int i = 0;
        for (int y = startY; true; y++) {
            for (int x = startX; x < startX + maxWidth; x++) {
                if (i >= content.length()) return;
                if (x > 0 && x < Constants.SCREEN_WIDTH) {
                    if (y > 0 && y < Constants.SCREEN_HEIGHT) {
                        frame.setChixelAt(x, y, content.charAt(i));
                    }
                }
                i++;
            }
        }
    }
}