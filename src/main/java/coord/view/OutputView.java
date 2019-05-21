/*
package coord;

import java.util.stream.IntStream;

public class OutputView {
    public static void printCoordinates(Points points) {
        points.sortByDescYAscX();
        StringBuilder result = new StringBuilder();
        IntStream.range(points.number(), 0).boxed().forEach(i -> {
            result.append(printYAxis(i));
            if (points.get(i - 1).y == points.get(i).y) {
                result.append(printPoint(points.get(i - 1), 0)).append(printPoint(points.get(i), points.get(i - 1).x));
                continue;
            }
            result.append(printPoint(points.get(i), 0));
        });
    }

    private static String printYAxis(int y) {
        return String.format("%2s|", y % 2 == 0 ? y : "");
    }

    private static String printPoint(Point point, int beginIndex) {

    }
}
*/