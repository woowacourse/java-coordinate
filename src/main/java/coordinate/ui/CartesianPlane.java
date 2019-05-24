package coordinate.ui;

import coordinate.domain.Figure;
import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class CartesianPlane {
    private static final int Y_RANGE = 24;

    List<Row> rows;

    public CartesianPlane() {
        rows = new ArrayList<>();
        configureEmptyPlane();
    }

    private void configureEmptyPlane() {
        for (int i = Y_RANGE; i >= 0; i--) {
            rows.add(new Row(i));
        }
        rows.add(new Row());
    }

    public void drawPoints(Figure figure) {
        for (Point point : figure.getPoints()) {
            rows.get(Y_RANGE - point.getY()).drawTile(point.getX());
        }
    }

    public List<Row> getRows() {
        return rows;
    }
}
