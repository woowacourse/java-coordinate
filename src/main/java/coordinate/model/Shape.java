package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Shape {

    public static final int LINE_NUMBER_OF_POINTS = 2;
    public static final int TRIANGLE_NUMBER_OF_POINTS = 3;
    public static final int SQUARE_NUMBER_OF_POINTS = 4;


    public static final Map<Integer, Function<List<Point>, Shape>> creator
            = new HashMap<Integer, Function<List<Point>, Shape>>() {
        {
            put(LINE_NUMBER_OF_POINTS, Line::new);
            put(TRIANGLE_NUMBER_OF_POINTS, Triangle::new);
            put(SQUARE_NUMBER_OF_POINTS, Square::new);
        }
    };

    public double getScore();

    public List<Point> getPoints();
}
