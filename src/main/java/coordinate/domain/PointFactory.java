package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class PointFactory {

    public static List<Point> generateCoordinateList(List<String> input) {
        List<Point> coordinates = new ArrayList<>();

        for (String inputCoordinate : input) {
            String[] splitPoints = inputCoordinate.split(",");
            Point newPoint = new Point(splitPoints[0],splitPoints[1]);
//            checkDuplicateCoordinate(coordinates, inputCoordinate);
            coordinates.add(newPoint);
        }
        return coordinates;
    }

    private static void checkDuplicateCoordinate(List<Point> coordinates, String inputCoordinate) {
        String[] splitPoints = inputCoordinate.split(",");
        Point newPoint = new Point(splitPoints[0],splitPoints[1]);
        if(coordinates.contains(newPoint)){
            throw new IllegalArgumentException("중복된 좌표는 안됩니다.");
        }
        coordinates.add(newPoint);
    }
}
