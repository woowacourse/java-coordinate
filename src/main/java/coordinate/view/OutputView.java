package coordinate.view;

import coordinate.model.*;

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
                        drawYAxis(sb, index);
                        drawHorizonLine(shape.getPoints(), sb, index);
                }
                drawXAxis(sb);
                System.out.println(sb.toString());
        }

        private static void drawYAxis(StringBuilder sb, int index) {
                sb.append(isEven(index) ? String.format("%2d", index) + VERTICAL_BAR : TWO_SPACE + VERTICAL_BAR);
        }

        private static boolean isEven(int index) {
                return (index % 2) == 0;
        }

        private static void drawHorizonLine(List<Point> points, StringBuilder sb, int index) {
                int x = 0;
                for (Point point : points) {
                        x = drawDot(sb, index, x, point);
                }
                sb.append(NEW_LINE);
        }

        private static int drawDot(StringBuilder sb, int i, int x, Point point) {
                if (point.getY().getNumber() == i) {
                        drawHorizonLineSpace(sb, x, point);
                        sb.append(DOT);
                        x = point.getX().getNumber() + 1;
                }
                return x;
        }

        private static void drawHorizonLineSpace(StringBuilder sb, int x, Point point) {
                for (int j = x; j < point.getX().getNumber(); j++) {
                        sb.append(TWO_SPACE);
                }
        }

        private static void drawXAxis(StringBuilder sb) {
                sb.append(TWO_SPACE).append(CROSS);
                for (int i = 0; i < MAX_RANGE; i++) {
                        sb.append(HORIZON_BAR);
                }
                sb.append(NEW_LINE).append(TWO_SPACE);
                for (int i = 0; i <= MAX_RANGE; i += 2) {
                        sb.append(String.format("%2d", i)).append(TWO_SPACE);
                }
        }
}
