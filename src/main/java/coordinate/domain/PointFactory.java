package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PointFactory {

    public static List<Point> generatePoints(List<Point> points, String x, String y) {

        if(Collections.indexOfSubList(points, Arrays.asList(new Point(x,y))) == -1){
            points.add(new Point(x,y));
        }
        return points;
    }
}
