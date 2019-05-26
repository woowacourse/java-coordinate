package coordinatecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private static final int MAXIMUM_NUMBER_OF_ROWS = 24;

    private List<Row> rows = new ArrayList<>();
    private Figure figure;

    public Graph(Figure figure) {
        this.figure = figure;

    for (int i = 0; i < MAXIMUM_NUMBER_OF_ROWS + 1; i++) {
            rows.add(new Row());
        }
        this.markPointsPositions();
    }

    private void markPointsPositions() {
        figure.getPoints().getPoints().forEach(point -> rows.get(point.getYValue().getValue()).setPosition(point.getXValue().getValue()));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = MAXIMUM_NUMBER_OF_ROWS; i > 0; i--) {
            stringBuilder.append(i + "|" + rows.get(i).toString() + "\n");
        }
        stringBuilder.append(0 + "|" + rows.get(0).toString());

        return stringBuilder.toString();
    }

}
