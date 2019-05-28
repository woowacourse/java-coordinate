package coordinate.view;

import coordinate.model.*;
import coordinate.model.framework.IShape;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
        private static final String TWO_SPACE = "  ";
        private static final String VERTICAL_BAR = "|";
        private static final String DOT = "★";
        private static final String NEW_LINE = "\n";
        private static final String CROSS = "+";
        private static final String HORIZON_BAR = "━";
        private static final String LINE_SCORE_MESSAGE = "두 점 사이의 거리는 ";
        private static final String TRIANGLE_SCORE_MESSAGE = "삼각형 넓이는 ";
        private static final String SQUARE_SCORE_MESSAGE = "사각형 넓이는 ";
        private static final int MAX_RANGE = 24;
        private static final Map<Class, String> MAPPING_SCORE_MESSAGE = new HashMap<Class, String>() {
                {
                        put(Line.class, LINE_SCORE_MESSAGE);
                        put(Triangle.class, TRIANGLE_SCORE_MESSAGE);
                        put(Square.class, SQUARE_SCORE_MESSAGE);
                }
        };

        public static void printResult(IShape shape) {
                System.out.print(MAPPING_SCORE_MESSAGE.get(shape.getClass()));
                System.out.println(shape.getScore());
        }

        public static void printCoordinate(IShape shape) {
                StringBuilder sb = new StringBuilder();
                for (int index = MAX_RANGE; index > 0; index--) {
                        sb.append(drawYAxis(index));
                        sb.append(drawHorizonLine(shape.getPoints(), index));
                }
                sb.append(drawXAxis());
                System.out.println(sb.toString());
        }

        private static String drawYAxis(int index) {
                return isEven(index) ? String.format("%2d", index) + VERTICAL_BAR : TWO_SPACE + VERTICAL_BAR;
        }

        private static boolean isEven(int index) {
                return (index % 2) == 0;
        }

        private static String drawHorizonLine(List<Point> points, int index) {
                StringBuilder sb = new StringBuilder();
                int x = 0;
                for (Point point : points) {
                        sb.append(point.getY() == index ? drawHorizonLineSpace(x, point) + DOT : "");
                        x = point.getY() == index ? point.getX() + 1 : x;
                }
                sb.append(NEW_LINE);
                return sb.toString();
        }

        private static String drawHorizonLineSpace(int x, Point point) {
                String str = "";
                for (int j = x; j < point.getX(); j++) {
                        str += TWO_SPACE;
                }
                return str;
        }

        private static String drawXAxis() {
                String str = TWO_SPACE + CROSS;
                for (int i = 0; i < MAX_RANGE; i++) {
                        str += HORIZON_BAR;
                }
                str += (NEW_LINE + TWO_SPACE);
                for (int i = 0; i <= MAX_RANGE; i += 2) {
                        str += (String.format("%2d", i) + TWO_SPACE);
                }
                return str;
        }
}
