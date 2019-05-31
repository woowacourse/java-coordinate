package coordinate.domain.graph;

import coordinate.domain.point.Point;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static final String HORIZONTAL_AXIS = "  +------------------------------------------------";
    private static final String HORIZONTAL_VALUE = " 0    2   4   6   8  10  12  14  16  18  20  22  24";
    private static final int MAX_VERTICAL_VALUE = 24;
    private static final int MIN_VERTICAL_VALUE = 1;
    private static final int ORIGIN_COORDINATE = 0;
    private static final String NEXT_LINE = "\n";

    private List<Row> rows = new ArrayList<>();

    public Graph() {
        for (int i = MAX_VERTICAL_VALUE; i >= MIN_VERTICAL_VALUE; i--) {
            rows.add(new Row(i));
        }
    }

    public void drawPoints(List<Point> points) {
        Point originPoint = new Point(ORIGIN_COORDINATE, ORIGIN_COORDINATE);
        int xCoordinate;
        int yCoordinate;

        for (Point point : points) {
            xCoordinate = originPoint.getDistanceX(point);
            yCoordinate = originPoint.getDistanceY(point);
            drawPoint(xCoordinate, yCoordinate);
        }
    }

    private void drawPoint(int xCoordinate, int yCoordinate) {
        rows.get(MAX_VERTICAL_VALUE - yCoordinate).paintPoint(xCoordinate);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Row row : rows) {
            stringBuilder.append(row).append(NEXT_LINE);
        }
        stringBuilder.append(HORIZONTAL_AXIS).append(NEXT_LINE);
        stringBuilder.append(HORIZONTAL_VALUE).append(NEXT_LINE);
        return stringBuilder.toString();
    }
}
