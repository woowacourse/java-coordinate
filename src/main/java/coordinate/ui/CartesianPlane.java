package coordinate.ui;

import coordinate.domain.Figure;
import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CartesianPlane {
    private static final int Y_RANGE = 24;
    private static final int X_BASE = 0;

    private List<Row> rows;

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
        Iterator<Point> iterator = figure.iterator();
        while (iterator.hasNext()) {
            Point nextPoint = iterator.next();
            rows.get(nextPoint.getYDifference(Y_RANGE)).drawTile(nextPoint.getXDifference(X_BASE));
        }
    }

    public List<Row> getRows() {
        return rows;
    }
}