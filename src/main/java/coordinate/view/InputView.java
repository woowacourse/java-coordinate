package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.FigureGenerator;
import coordinate.domain.Point;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COORDINATE_PATTERN = "^\\((\\d*),(\\d*)\\)$";
    private static final String GET_COORDINATE_MESSAGE = "좌표를 입력하세요.";
    private static final String DUPLICATION_EXCEPTION_MESSAGE = "중복된 좌표가 입력되었습니다.";
    private static final String INPUT_FORMAT_EXCEPTION_MESSAGE = "올바른 형식으로 입력해 주세요.";

    public static Figure getFigure() {
        try {
            OutputView.printMessage(GET_COORDINATE_MESSAGE);
            String userInput = getUserInput();
            return FigureGenerator.generate(makePoints(userInput));
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return getFigure();
        }
    }

    private static String getUserInput() {
        return SCANNER.nextLine();
    }

    static List<Point> makePoints(String userInput) {
        List<Point> points = new ArrayList<>();

        List<String> coordinates = new ArrayList<>(Arrays.asList(userInput.split("-")));
        coordinates.stream().forEach(coordinate -> points.add(makePoint(coordinate)));

        validateDuplication(points);

        return points;
    }

    private static void validateDuplication(List<Point> points) {
        Set<Point> nonDuplicatedPoints = new HashSet<>(points);
        if (nonDuplicatedPoints.size() != points.size()) {
            throw new IllegalArgumentException(DUPLICATION_EXCEPTION_MESSAGE);
        }
    }

    private static Point makePoint(String coordinate) {
        Matcher matcher = Pattern.compile(COORDINATE_PATTERN).matcher(coordinate);
        if (!matcher.find()) throw new IllegalArgumentException(INPUT_FORMAT_EXCEPTION_MESSAGE);

        return new Point(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
    }
}
