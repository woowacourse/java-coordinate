package coordinate.view;

import coordinate.model.IShape;
import coordinate.model.Point;
import coordinate.model.PointNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
        private static final String INPUT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)((-)\\(([0-9]+)(,)([0-9]+)\\))*";
        private static final String DELIMITER = "-";
        private static final String POINT_REGEX = "\\(([0-9]+)(,)([0-9]+)\\)";

        public static List<Point> inputPoints() {
                System.out.println("좌표를 입력하세요.");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                checkValidForm(input);
                return makePoints(Arrays.asList(input.split(DELIMITER)));
        }

        private static void checkValidForm(String input) {
                if (!input.matches(INPUT_REGEX)) {
                        throw new IllegalArgumentException("정상적인 좌표 형식이 아닙니다.");
                }
        }

        private static List<Point> makePoints(List<String> inputs) {
                List<Point> points = new ArrayList<>();
                for (String input : inputs) {
                        Matcher matcher = Pattern.compile(POINT_REGEX).matcher(input);
                        matcher.matches();
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(3));
                        points.add(new Point(x, y));
                }
                checkPointNumber(points);
                return points;
        }

        private static void checkPointNumber(List<Point> points) {
                if (points.size() != IShape.LINE_NUMBER_OF_POINTS &&
                    points.size() != IShape.TRIANGLE_NUMBER_OF_POINTS &&
                    points.size() != IShape.SQUARE_NUMBER_OF_POINTS) {
                        throw new IllegalArgumentException("점의 수는 2개, 3개 또는 4개를 입력해주세요.");
                }
        }
}
