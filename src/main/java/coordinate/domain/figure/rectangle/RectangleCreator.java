package coordinate.domain.figure.rectangle;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.FigureCreator;
import coordinate.domain.point.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RectangleCreator implements FigureCreator {
    @Override
    public Figure create(List<Point> points) {
        points = sortPoints(points);
        return new Rectangle(points);
    }

    private List<Point> sortPoints(List<Point> points) {
        Collections.sort(points);
        return new ArrayList<>(Arrays.asList(
                points.get(0),
                points.get(1),
                points.get(3),
                points.get(2)
        ));
    }
}
