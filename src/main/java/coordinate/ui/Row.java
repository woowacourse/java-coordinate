package coordinate.ui;

import coordinate.utils.Modulo;

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
            tiles.add(new Tile(Modulo.isEvenNumber(i) ? String.valueOf(i) : EMPTY));
        }
    }

    public Row(int yCoordinate) {
        tiles = new ArrayList<>();
        addAxisTile(yCoordinate);
        for (int i = 1; i <= X_RANGE; i++) {
            tiles.add(new Tile(yCoordinate > 0 ? EMPTY : "---"));
        }
    }

    private void addAxisTile(int yCoordinate) {
        if (yCoordinate > 0) {
            tiles.add(new Tile((Modulo.isEvenNumber(yCoordinate) ? String.valueOf(yCoordinate)
                    : EMPTY)));
            tiles.add(new Tile("|"));
            return;
        }
        tiles.add(new Tile(EMPTY));
        tiles.add(new Tile("+"));
    }

    void drawTile(int xCoordinate) {
        tiles.get(xCoordinate + 1).draw();
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
