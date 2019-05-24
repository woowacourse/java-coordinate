package coordinate.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

    private List<ViewLine> viewLines;
    private Figure figure;

    public Graph(Figure figure){
        viewLines = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            viewLines.add(new ViewLine());
        }

        this.figure = figure;
    }

    public void setPosition(List<Point> points){
        points.forEach(point -> viewLines.get(point.getYValue().getValue()).setPosition(point.getXValue().getValue()));
    }

    public void markPointsPositions() {
        figure.getPoints().forEach(point -> viewLines.get(point.getYValue().getValue()).setPosition(point.getXValue().getValue()));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Collections.reverse(viewLines);
        viewLines.forEach(viewLine -> stringBuilder.append(24 - viewLines.indexOf(viewLine) + "|" + viewLine.toString() + "\n"));
        return stringBuilder.toString();
    }
}