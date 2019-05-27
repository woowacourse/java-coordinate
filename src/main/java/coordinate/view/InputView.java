package coordinate.view;

import coordinate.model.Figure;
import coordinate.model.FigureFactory;
import coordinate.model.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final String INPUT_COORDINATE = "좌표를 입력하세요.";
    private static final String ERROR_INVALID_COORDINATES = "올바르지 않은 입력값입니다.";
    private static final String ERROR_DUPLICATE_POINTS = "중복된 좌표가 존재합니다.";
    private static final String POINT_DELIMITER = "-";
    private static Scanner scanner = new Scanner(System.in);

    public static Figure inputCoordinates() {
        System.out.println(INPUT_COORDINATE);
        return inputCoordinates(scanner.nextLine());
    }

    public static Figure inputCoordinates(String input) {
        try {
            input = input.replace(" ", "");
            checkAccuracyOfPoints(input);
            List<Point> points = generatePoints(input);
            return FigureFactory.create(points);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputCoordinates();
        }
    }

    private static void checkAccuracyOfPoints(String input) {
        Pattern pattern = Pattern.compile("(\\([0-9]{1,2},[0-9]{1,2}\\))(-(\\([0-9]{1,2},[0-9]{1,2}\\))){0,3}");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
        }
    }

    private static List<Point> generatePoints(String input) {
        String[] inputPoints = input.split(POINT_DELIMITER);

        List<Point> points = new ArrayList<>();
        for (String inputPoint : inputPoints) {
            points.add(generatePoint(inputPoint));
        }
        checkDuplicationOf(points);
        return points;
    }

    private static Point generatePoint(String inputPoint) {
        Pattern pattern = Pattern.compile("\\(([0-9]{1,2}),([0-9]{1,2})\\)");
        Matcher matcher = pattern.matcher(inputPoint);
        if (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            return new Point(x, y);
        }
        throw new IllegalArgumentException(ERROR_INVALID_COORDINATES);
    }

    private static void checkDuplicationOf(List<Point> points) {
        if (points.size() != new HashSet<>(points).size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_POINTS);
        }
    }
}
