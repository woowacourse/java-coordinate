package coordinate.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureGenerator {
    private static final String OUT_OF_COORDINANE_COUNT_EXCEPTION_MASSAGE = "좌표의 개수는 2~4개만 가능합니다.";

    private static final Map<Integer, FigureCreator> ifExercise = new HashMap<>();

    static {
        ifExercise.put(2, Line::new);
        ifExercise.put(3, Triangle::new);
        ifExercise.put(4, Rectangle::new);
    }

    public static Figure generate(List<Point> points) {
        int size = points.size();
        validPointsSize(size);

        return ifExercise.get(size).create(points);
    }

    private static void validPointsSize(int size) {
        if (size < 2 || size > 4)
            throw new IllegalArgumentException(OUT_OF_COORDINANE_COUNT_EXCEPTION_MASSAGE);
    }


}
