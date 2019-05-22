package coordinate.domain.view;

import coordinate.domain.Coordinate;
import coordinate.domain.Point;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String DEFAULT_DELIMITERS = "\\([0-9]{1,2},[0-9]{1,2}\\)";

    public static Coordinate InputCoordinate() {
        try {
            List<Point> points = new ArrayList<>();
            System.out.println("좌표를 입력하세요");
            Scanner scanner = new Scanner(System.in);
            String[] coordinates = scanner.nextLine().split("-");

            List<String> coordinate = new ArrayList<>(Arrays.asList(coordinates));
            coordinate.stream().forEach(c -> isValidFormat(c)); //정규패턴에 대한 유효성 검사
            coordinate = coordinate.stream().map(s -> s.substring(1, 5)).collect(Collectors.toList()); //괄호 제거

            return CoordinateFactory.generateCoordinate(coordinate, points);
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
