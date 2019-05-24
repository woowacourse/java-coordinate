package coordinate.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface Shape {

    double getScore();

    List<Point> getPoints();
}
