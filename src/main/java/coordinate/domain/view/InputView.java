package coordinate.domain.view;

import coordinate.domain.Coordinate;
import coordinate.domain.Point;
import coordinate.domain.PointFactory;

import java.util.*;

public class InputView {
    private static final String DEFAULT_DELIMITERS = "\\([0-9]{1,2},[0-9]{1,2}\\)";

    public static Coordinate InputCoordinate() {
        try {
            List<Point> points = new ArrayList<>();
            System.out.println("좌표를 입력하세요");
            Scanner scanner = new Scanner(System.in);
            String[] coordinates = scanner.nextLine().split("-");
            for (String coordinate : coordinates) {
                isValidFormat(coordinate);
            }
            for (String coordinate : coordinates) {
                String[] point = coordinate.split(",");
                PointFactory.generatePoints(points, point[0], point[1]);
            }
            return new Coordinate(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputCoordinate();
        }
    }

    private static void isValidFormat(String coordinate) {
        if (!coordinate.matches(DEFAULT_DELIMITERS)) {
            throw new IllegalArgumentException("올바른 형식을 입력하세요.");
        }
    }

}
