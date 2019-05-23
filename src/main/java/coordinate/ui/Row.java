package coordinate.ui;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int X_RANGE = 24;
    private static final String EMPTY = "";

    private List<Tile> tiles;

    public Row() {
        tiles = new ArrayList<>();
        tiles.add(new Tile(String.valueOf(0)));
        tiles.add(new Tile(EMPTY));
        for (int i = 1; i <= X_RANGE; i++) {
            tiles.add(new Tile(i % 2 == 0 ? String.valueOf(i) : EMPTY));
        }
    }

    public Row(int yCoordinate) {
        tiles = new ArrayList<>();
        addAxisTile(yCoordinate);
        for (int i = 1; i <= X_RANGE; i++) {
            tiles.add(new Tile(yCoordinate > 0 ? EMPTY : "----"));
        }
    }

    private void addAxisTile(int yCoordinate) {
        if (yCoordinate > 0) {
            tiles.add(new Tile((yCoordinate % 2 == 0 ? String.valueOf(yCoordinate)
                    : EMPTY)));
            tiles.add(new Tile("|"));
            return;
        }
        tiles.add(new Tile(EMPTY));
        tiles.add(new Tile("+---"));
    }

    void drawTile(int xCoordinate) {
        tiles.get(xCoordinate + 1).draw();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%4s%-4s",tiles.get(0).toString(), tiles.get(1).toString()));
        for (int i = 2; i < tiles.size(); i++) {
            sb.append(String.format("%4s",tiles.get(i).toString()));
        }
        return sb.toString();
    }
}
