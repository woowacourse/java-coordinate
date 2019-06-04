package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.FigureGenerator;
import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COORDINATE_PATTERN = "^\\((\\d*),(\\d*)\\)$";
    private static final String DELIMITER = "-";

    public static Figure getFigure() {
        try {
            String userInput = getUserInput();
            List<String> coordinates = makeCoordinates(userInput);
            Points points = makePoints(coordinates);
            return FigureGenerator.generate(points);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return getFigure();
        }
    }

    private static String getUserInput() {
        System.out.println("좌표를 입력하세요.");
        return SCANNER.nextLine();
    }

    private static ArrayList<String> makeCoordinates(String userInput) {
        return new ArrayList<>(Arrays.asList(userInput.split(DELIMITER)));
    }

    static Points makePoints(List<String> coordinates) {
        List<Point> points = new ArrayList<>();

        for (String coordinate : coordinates) {
            points.add(makePoint(coordinate));
        }

        return new Points(points);
    }

    private static Point makePoint(String coordinate) {
        Matcher matcher = Pattern.compile(COORDINATE_PATTERN).matcher(coordinate);
        if (!matcher.find()) {
            throw new IllegalArgumentException("올바른 형식으로 입력해 주세요.");
        }

        return new Point(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
    }
}
