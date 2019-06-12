package coordinate.domain.figure.triangle;

import coordinate.domain.figure.AbstractFigure;
import coordinate.domain.point.Point;

import java.util.List;
import java.util.stream.IntStream;

public class Triangle extends AbstractFigure {
    public static final int TRIANGLE_SIZE = 3;
    private static final String TRIANGLE_NAME = "삼각형";

    public Triangle(List<Point> points) {
        super(points);
        validateTriangle();
    }

    private void validateTriangle() {
        if (hasParallel()) {
            throw new InvalidTriangleException("한 직선에 점이 존재합니다.");
        }
    }

    private boolean hasParallel() {
        return IntStream.range(0, size())
                .allMatch(i -> getVector(i).isParallelVector(getVector((i + 1) % size())));
    }

    @Override
    public int size() {
        return TRIANGLE_SIZE;
    }

    @Override
    public String getName() {
        return TRIANGLE_NAME;
    }

    @Override
    public double area() {
        return super.area() / 2;
    }
}
