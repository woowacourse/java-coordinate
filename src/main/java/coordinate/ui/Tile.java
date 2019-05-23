package coordinate.ui;

public class Tile {
    private String tileContent;

    public Tile(String tileContent) {
        this.tileContent = tileContent;
    }

    public void draw() {
        tileContent = "●";
    }

    @Override
    public String toString() {
        return tileContent;
    }
}
