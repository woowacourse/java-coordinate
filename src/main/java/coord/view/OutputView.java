package coord.view;

import coord.model.Line;
import coord.model.Point;
import coord.model.Points;
import coord.model.figure.ConvexPolygon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final int SCREEN_MAX_WIDTH = 50;
    private static final int Y_MAX = 24;
    private static final int Y_MIN = 0;
    private static final int X_MAX = 24;
    private static final int X_MIN = 0;


    public static void printScreen(Points points) {
        List<Point> aligned = new ArrayList<>();
        aligned.addAll(points.getPoints());
        aligned.sort((a, b) -> (a.y != b.y) ? b.y - a.y : a.x - b.x);
        int i = 0;
        for (int j = Y_MAX; j >= Y_MIN; j--) {
            if (i < aligned.size() && aligned.get(i).y == j) {
                System.out.println(repeatBlank(aligned.get(i).x - 1) + "*");
                i++;
            } else {
                System.out.println();
            }
        }
    }

    private static String repeatBlank(int n) {
        StringBuilder blank = new StringBuilder();
        IntStream.range(0, n).boxed().forEach(i -> blank.append("   "));
        return blank.toString();
    }

    public static void printLengthOfLine(Line line) {
        System.out.format("두 점 사이 거리는 %g입니다.", line.length());
    }

    public static void printAreaOfFigure(ConvexPolygon convexPolygon) {
        System.out.format("%d각형의 넓이는 %g입니다.", convexPolygon.getNumberOfAngles(), convexPolygon.area());
    }
}