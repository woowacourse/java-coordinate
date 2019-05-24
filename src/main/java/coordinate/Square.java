package coordinate;

import java.util.*;

public class Square extends AbstractFigure {

    public Square(final List<Point> points) {
        super(points);
    }

    @Override
    public Double getArea() {
        //TODO Deep copy해서 넣기
        Point origin = this.points.get(0);
        Line line1 = Line.of(Arrays.asList(origin, getSameX(origin)));
        Line line2 = Line.of(Arrays.asList(origin, getSameY(origin)));
        return (line1.length() * line2.length());
    }

    private Point getSameX(final Point origin) {
        Optional<Point> optPoint = points.subList(1, points.size()).stream()
                .filter(origin::isSameX)
                .findFirst();

        return optPoint.orElseThrow(IllegalArgumentException::new);
    }

    private Point getSameY(final Point origin) {
        Optional<Point> optPoint = points.subList(1, points.size()).stream()
                .filter(origin::isSameY)
                .findFirst();

        return optPoint.orElseThrow(IllegalArgumentException::new);
    }
}
