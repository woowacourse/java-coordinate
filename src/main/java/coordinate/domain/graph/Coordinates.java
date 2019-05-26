package coordinate.domain.graph;

import coordinate.Figure;
import coordinate.FigureFactory;
import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Coordinates {
    private static final FigureFactory FIGURE_FACTORY = FigureFactory.getInstance();

    private final List<Point> points;
    private final Figure figure;

    public Coordinates(final List<Point> points) {
        validate(points);
        this.points = new ArrayList<>(points);
        this.figure = FIGURE_FACTORY.create(points);
    }

    private void validate(final List<Point> points) {
        Set DuplicationEliminatedPoints = new HashSet<>(points);
        if (DuplicationEliminatedPoints.size() != points.size()) {
            throw new IllegalArgumentException("위치가 같은 점이 존재합니다");
        }
    }

    public Double getAreaElement() throws IllegalArgumentException {
        return figure.getArea();
    }

    public Figure getFigure() {
        return figure;
    }
}
