package coordinate.domain.figure.rectangle;

import coordinate.domain.figure.AbstractFigure;
import coordinate.domain.point.Point;

import java.util.List;
import java.util.stream.IntStream;

public class Rectangle extends AbstractFigure {
    public static final int RECTANGLE_SIZE = 4;
    private static final String RECTANGLE_NAME = "사각형";

    public Rectangle(List<Point> points) {
        super(points);
        validateRectangle();
    }

    private void validateRectangle() {
        if (hasGeneralVector()) {
            throw new InvalidRectangleException("직사각형을 만들 수 없습니다.");
        }
    }

    private boolean hasGeneralVector() {
        return IntStream.range(0, size())
                .anyMatch(i -> getVector(i).isGeneralVector(getVector((i + 1) % size())));
    }

    @Override
    public int size() {
        return RECTANGLE_SIZE;
    }

    @Override
    public String getName() {
        return RECTANGLE_NAME;
    }
}
