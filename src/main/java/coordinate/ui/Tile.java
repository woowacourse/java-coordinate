package coordinate.ui;

public class Tile {
    private String tileContent;

    Tile(String tileContent) {
        this.tileContent = tileContent;
    }

    void draw() {
        tileContent = "ｘ";
    }

    @Override
    public String toString() {
        return tileContent;
    }
}
