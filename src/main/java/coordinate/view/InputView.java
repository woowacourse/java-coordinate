package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static String POINT_RANGE = "[1-2]?[0-9]{1}";
    private static String POINT_FORMAT = String.format("(%s,%s)", POINT_RANGE, POINT_RANGE);
    private static String POINTS_FORMAT = String.format("^\\(%s\\)(?:-\\(%S\\)){1,3}?$", POINT_FORMAT, POINT_FORMAT);

    public static Points inputPoints() {
        try {
            System.out.println("좌표를 입력하세요.");
            String input = scanner.nextLine();
            vaildPointsFormat(input);
            return new Points(convertPoints(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPoints();
        }
    }

    static void vaildPointsFormat(String input) {
        Pattern pointsFormatPattern = Pattern.compile(POINTS_FORMAT);
        Matcher pointsFormatMatcher = pointsFormatPattern.matcher(input);

        if (!pointsFormatMatcher.find()) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다.");
        }
    }

    static List<Point> convertPoints(String input) {
        List<Point> points = new ArrayList<>();
        Pattern pointFormatPattern = Pattern.compile(POINT_FORMAT);
        Matcher pointFormatMatcher = pointFormatPattern.matcher(input);
        while (pointFormatMatcher.find()) {
            points.add(convertPoint(pointFormatMatcher.group()));
        }
        return points;
    }

    private static Point convertPoint(String input) {
        List<Integer> point = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                ;
        return new Point(point.get(0), point.get(1));
    }
}
