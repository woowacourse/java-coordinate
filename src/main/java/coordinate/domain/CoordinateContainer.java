package coordinate.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CoordinateContainer {
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;

    private static final List<Coordinate> coordinates;

    static {
        coordinates = new ArrayList<>();
        for (int i = MIN_COORDINATE; i <= MAX_COORDINATE; i++) {
            coordinates.add(new Coordinate(i));
        }
    }

    public static Coordinate get(int index) {
        validateCoordinateRange(index);
        return Collections.unmodifiableList(coordinates).get(index);
    }

    private static void validateCoordinateRange(int coordinateIndex) {
        if (coordinateIndex < MIN_COORDINATE || coordinateIndex > MAX_COORDINATE) {
            throw new IllegalArgumentException("좌표는 0과 24 사이의 값이여야 합니다.");
        }
    }
}
