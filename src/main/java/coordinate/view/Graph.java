package coordinate.view;

import coordinate.model.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {

    private List<ViewLine> viewLines;

    Graph() {
        viewLines = new ArrayList<>();

        for (int i = 0; i < 25; i++) {
            viewLines.add(new ViewLine());
        }
    }

    void setPosition(List<Point> points) {
        points.forEach(point -> viewLines.get(point.getYValue().getValue()).setPosition(point.getXValue().getValue()));
    }

    @Override
    public String toString() {
        Collections.reverse(viewLines);
        return viewLines.stream()
                .map(viewLine -> 24 - viewLines.indexOf(viewLine) + "|" + viewLine.toString())
                .collect(Collectors.joining("\n"));
    }
}