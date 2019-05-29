package coordinate.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rectangle extends Figure implements AvailableArea {
    private static final int VALID_LENGTH_OF_POINTS = 4;
    private static final int SIDE_1_VECTOR_INDEX = 0;
    private static final int SIDE_2_VECTOR_INDEX = 1;
    private static final int OPPOSITE_VECTOR_INDEX = 2;

    private final List<Vector> vectors;

    public Rectangle(Vertices vertices) {
        super(vertices, VALID_LENGTH_OF_POINTS);
        vectors = sortVectors();
        validateRectanglePoints();
    }

    private List<Vector> sortVectors() {
        return IntStream.range(1, 4)
                .mapToObj(i -> getVertices().vector(0, i))
                .sorted(Vector::compareTo)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void validateRectanglePoints() {
        Vector side1 = vectors.get(SIDE_1_VECTOR_INDEX);
        Vector side2 = vectors.get(SIDE_2_VECTOR_INDEX);
        Vector opposite = vectors.get(OPPOSITE_VECTOR_INDEX);

        if ((side1.dotProduct(side2) != 0) || !side1.add(side2).equals(opposite)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    @Override
    public double area() {
        return (double) Math.abs(vectors.get(SIDE_1_VECTOR_INDEX).crossProduct(vectors.get(SIDE_2_VECTOR_INDEX)));
    }

}
