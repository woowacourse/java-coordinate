package coord.view;

import coord.model.figure.ConvexPolygon;
import coord.model.figure.Line;
import coord.model.figure.Point;
import coord.model.figure.Points;

import java.util.stream.IntStream;

public class OutputView {
    private static final int Y_MAX = 24;
    private static final int Y_MIN = 0;

    public static void printScreen(Points points) {
        Points aligned = new Points(points, (a, b) -> (a.y() != b.y() ? b.y() - a.y() : a.x() - b.x()));
        StringBuilder result = new StringBuilder();
        for (int y = Y_MAX, cursor = 0, offset = 0; y >= Y_MIN;) {
            if (cursor < points.number() && y == aligned.get(cursor).y()) {
                result.append(printLine(aligned.get(cursor), offset));
                offset = aligned.get(cursor).x();
                cursor++;
                continue;
            }
            result.append("\n");
            offset = 0;
            y--;
        }
        System.out.println(result);
    }

    private static String printLine(Point p, int offset) {
        return repeatBlank(offset + p.x() - 1) + "-*-";
    }

    private static String repeatBlank(int n) {
        StringBuilder blank = new StringBuilder();
        IntStream.range(0, n).boxed().forEach(i -> blank.append("   "));
        return blank.toString();
    }

    public static void printLengthOfLine(Line line) {
        System.out.format("두 점 사이 거리는 %g입니다.", line.length());
    }

    public static void printAreaOfFigure(ConvexPolygon polygon) {
        System.out.format("%d각형의 넓이는 %g입니다.", polygon.getNumberOfAngles(), polygon.area());
    }
}