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

    private static final Map<Class, String> scoreMessage = new HashMap<Class, String>(){
        {
            put(Line.class, LINE_SCORE_MESSAGE);
            put(Triangle.class, TRIANGLE_SCORE_MESSAGE);
            put(Square.class, SQUARE_SCORE_MESSAGE);
        }
    };

    public static void printResult(Shape shape) {
        System.out.print(scoreMessage.get(shape.getClass()));
        System.out.println(shape.getScore());
    }

    public static void printCoordinate(Shape shape) {
        StringBuilder sb = new StringBuilder();
        for (int i = MAX_RANGE; i > 0; i--) {
            drawYAxis(sb, i);
            drawHorizonLine(shape.getPoints(), sb, i);
            sb.append(NEW_LINE);
        }
        sb.append(TWO_SPACE).append(CROSS);
        drawXAxis(sb);
        System.out.println(sb.toString());
    }

    private static void drawXAxis(StringBuilder sb) {
        for (int i = 0; i < MAX_RANGE; i++) {
            sb.append(HORIZON_BAR);
        }
        sb.append(NEW_LINE).append(TWO_SPACE);
        for (int i = 0; i <= MAX_RANGE; i += 2) {
            sb.append(String.format("%2d", i)).append(TWO_SPACE);
        }
    }

    private static void drawHorizonLine(List<Point> points, StringBuilder sb, int i) {
        int x = 0;
        for (Point point : points) {
            x = drawDot(sb, i, x, point);
        }
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

    private static void drawYAxis(StringBuilder sb, int i) {
        if (i % 2 == 0) {
            sb.append(String.format("%2d", i)).append(VERTICAL_BAR);
            return;
        }
            sb.append(TWO_SPACE).append(VERTICAL_BAR);
    }
}
