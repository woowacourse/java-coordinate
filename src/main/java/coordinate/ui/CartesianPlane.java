package coordinate.ui;

import coordinate.domain.Figure;
import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class CartesianPlane {
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final int Y_RANGE = 24;

    List<Row> rows;

    public CartesianPlane() {
        rows = new ArrayList<>();
        configureEmptyPlane();
    }

    private void configureEmptyPlane() {
        rows.add(new Row());
        for (int i = 0; i <= Y_RANGE; i++) {
            rows.add(new Row(i));
        }
    }

    public void drawPoints(Figure figure) {
        for (Point point : figure.getPoints()) {
            rows.get(point.getY() + 1).drawTile(point.getX());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = rows.size() - 1; i >= 0; i--) {
            sb.append(rows.get(i).toString() + NEWLINE);
        }
        return sb.toString();
    }
}
