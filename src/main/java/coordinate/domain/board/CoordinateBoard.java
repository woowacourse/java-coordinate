package coordinate.domain.board;

import coordinate.Figure;
import coordinate.FigureFactory;
import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoordinateBoard {
    private static final FigureFactory FIGURE_FACTORY = FigureFactory.getInstance();

    private final List<Point> points;
    private final Figure figure;

    public CoordinateBoard(final List<Point> points) {
        validate(points);
        this.points = new ArrayList<>(points);
        this.figure = FIGURE_FACTORY.create(points);
    }

    private void validate(final List<Point> points) {
        Set temp = new HashSet<>(points);
        if (temp.size() != points.size()) {
            throw new IllegalArgumentException("도형을 만들 수 없습니다");
        }
    }

    public List<Point> getPoints() {
        return new ArrayList<>(this.points);
    }

    public Double getAreaElement() throws IllegalArgumentException {
        return figure.getArea();
    }
}
