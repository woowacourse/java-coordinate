package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class CoordinateFactory {

    public static List<Coordinate> generateCoordinateList(List<String> input) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (String inputCoordinate : input) {
            checkDuplicateCoordinate(coordinates, inputCoordinate);
        }
        return coordinates;
    }

    private static void checkDuplicateCoordinate(List<Coordinate> coordinates, String inputCoordinate) {
        String[] splitPoints = inputCoordinate.split(",");
        Coordinate coordinate = generateCoordinate(splitPoints[0],splitPoints[1]);
        coordinates.add(coordinate);
    }

    private static Coordinate generateCoordinate(String x, String y) {
        return new Coordinate(new X(x), new Y(y));
    }
}
