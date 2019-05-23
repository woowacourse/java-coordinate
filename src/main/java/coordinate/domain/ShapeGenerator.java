package coordinate.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShapeGenerator {
    private static final String INPUT_PATTERN_REGEX = "(\\([0-9]+,[0-9]+\\)-)*\\([0-9]+,[0-9]+\\)";
    private static final String POINT_REGEX = "[0-9]+,[0-9]+";
    private static final int X_COORDINATE_INDEX = 0;
    private static final int Y_COORDINATE_INDEX = 1;
    private static final int LINE_POINTS_NUMBER = 2;
    private static final int TRIANGLE_POINTS_NUMBER = 3;
    private static final int RECTANGLE_POINTS_NUMBER = 4;

    public static Shape generateShape(String input) {
        List<Point> points = generatePoints(input);
        Map<Integer, Shape> shapeMapper = new HashMap<>();
        shapeMapper.put(LINE_POINTS_NUMBER, new Line());
        shapeMapper.put(TRIANGLE_POINTS_NUMBER, new Triangle());
        shapeMapper.put(RECTANGLE_POINTS_NUMBER, new Rectangle());

        return shapeMapper.get(validatePointsNumber(points.size())).setShape(points);
    }

    private static int validatePointsNumber(int size) {
        if (LINE_POINTS_NUMBER <= size && size <= RECTANGLE_POINTS_NUMBER) {
            return size;
        }
        throw new IllegalArgumentException("좌표의 개수는 2개 이상, 4개 이하여야 합니다.");
    }

    private static List<Point> generatePoints(String input) {
        validatePattern(input);
        return initializePoints(input);
    }

    private static void validatePattern(String input) {
        if (!input.matches(INPUT_PATTERN_REGEX)) {
            throw new IllegalArgumentException("올바르게 다시 입력해 주세요");
        }
    }

    private static List<Point> initializePoints(String input) {
        List<Point> points = new ArrayList<>();
        Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
        String[] pointCoordinate;

        while (matcher.find()) {
            pointCoordinate = input.substring(matcher.start(), matcher.end()).split(",");
            points.add(new Point(new Coordinate(Integer.parseInt(pointCoordinate[X_COORDINATE_INDEX])),
                    new Coordinate(Integer.parseInt(pointCoordinate[Y_COORDINATE_INDEX]))));
        }
        return points;
    }

}
