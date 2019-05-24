package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class PointFactory {

    public static List<Point> generateCoordinateList(List<String> input) {
        List<Point> coordinates = new ArrayList<>();

        for (String inputCoordinate : input) {
            String[] splitPoints = inputCoordinate.split(",");
            Point newPoint = new Point(splitPoints[0],splitPoints[1]);
            coordinates.add(newPoint);
        }
        return coordinates;
    }

}
