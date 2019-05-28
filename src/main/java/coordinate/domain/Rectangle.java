package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rectangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 4;
    private static final String INVALID_RECTANGLE_POINTS_MESSAGE = "직사각형의 좌표를 입력해 주세요.";

    private Double area;

    public Rectangle(Vertices vertices) {
        super(vertices, VALID_LENGTH_OF_POINTS);
        validateRectanglePoints();
    }

    private void validateRectanglePoints() {
        List<Vector> vectorsFrom0 = IntStream.range(1, 4)
                .mapToObj(i -> getVertices().vector(0, i))
                .sorted(Vector::compareTo)
                .collect(Collectors.toCollection(ArrayList::new));
        Vector side1 = vectorsFrom0.get(0);
        Vector side2 = vectorsFrom0.get(1);
        Vector opposite = vectorsFrom0.get(2);

        area = (double) Math.abs(side1.crossProduct(side2));

        if ((side1.dotProduct(side2) != 0) || !side1.add(side2).equals(opposite)) {
            throw new IllegalArgumentException(INVALID_RECTANGLE_POINTS_MESSAGE);
        }
    }

    @Override
    public double area() {
        return area;
    }

    @Override
    public String toString() {
        return "사각형의 넓이는 " + area();
    }
}
