package coord.view;

import coord.model.Figure;
import coord.model.Line;

public class OutputView {
    public static void printLengthOfLine(Line line) {
        System.out.println("두 점 사이 거리는 " + line.length() + "입니다.");
    }
    public static void printAreaOfFigure(Figure figure) {
        System.out.println(figure.getName() + "의 넓이는 " + figure.area() + "입니다.");
    }
}

/*
    public static void printCoordinates(Points points) {
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

*/