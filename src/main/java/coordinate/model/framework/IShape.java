package coordinate.model.framework;

import coordinate.model.Line;
import coordinate.model.Point;
import coordinate.model.Square;
import coordinate.model.Triangle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface IShape {
        //각 도형의 Point 수
        int LINE_NUMBER_OF_POINTS = 2;
        int TRIANGLE_NUMBER_OF_POINTS = 3;
        int SQUARE_NUMBER_OF_POINTS = 4;

        //4개의 Point 인덱스 X가 작은 순 (같다면 Y가 작은 순)
        int FIRST_POINT = 0;
        int SECOND_POINT = 1;
        int THIRD_POINT = 2;
        int FOURTH_POINT = 3;

        Map<Integer, Function<List<Point>, IShape>> MAPPING_SHAPE = new HashMap<Integer, Function<List<Point>, IShape>>() {
                {
                        put(LINE_NUMBER_OF_POINTS, Line::new);
                        put(TRIANGLE_NUMBER_OF_POINTS, Triangle::new);
                        put(SQUARE_NUMBER_OF_POINTS, Square::new);
                }
        };

        double getScore();

        List<Point> getPoints();
}
