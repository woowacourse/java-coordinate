package coordinate.domain.figure;

import coordinate.domain.Vector;
import coordinate.domain.point.Point;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract public class AbstractFigure implements Figure {
    private static final int SQUARE = 2;

    private final List<Point> points;
    private final List<Vector> vectors;

    public AbstractFigure(List<Point> points) {
        validAbstractFigure(points);
        this.points = Collections.unmodifiableList(points);
        this.vectors = Collections.unmodifiableList(createVectors());
    }

    private void validAbstractFigure(List<Point> points) {
        if (new HashSet<>(points).size() != size()) {
            throw new InvalidAbstractFigureException(getName() + "은 서로 다른 점의 수가 " + size() + "개여야 합니다.");
        }
    }

    private List<Vector> createVectors() {
        return IntStream.range(0, size())
                .mapToObj(index -> new Vector(points.get(index), points.get((index + 1) % points.size())))
                .collect(Collectors.toList());
    }

    protected Point getPoint(int index) {
        return points.get(index);
    }

    protected Vector getVector(int index) {
        return vectors.get(index);
    }

    public boolean contain(Point point) {
        return points.contains(point);
    }

    @Override
    public double area() {
        Vector firstVector = vectors.get(0);
        Vector lastVector = vectors.get(size() - 1);

        return Math.sqrt(Math.pow(firstVector.length(), SQUARE)
                * Math.pow(lastVector.length(), SQUARE)
                - Math.pow(firstVector.calculateInnerProduct(lastVector), SQUARE));
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractFigure that = (AbstractFigure) o;
        return Objects.equals(points, that.points) &&
                Objects.equals(vectors, that.vectors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points, vectors);
    }
}
