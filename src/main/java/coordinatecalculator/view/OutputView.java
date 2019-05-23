package coordinatecalculator.view;

import coordinatecalculator.domain.Point;
import coordinatecalculator.domain.Points;
import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class OutputView {
    public static void printResult(Figure figure) {
        System.out.println(figure.makeResult());
    }

    public static void drawGraph(Figure figure) {
        System.out.println(draw(figure.getPoints()));
    }

    private static String draw(Points points) {
        List<Point> po = points.getSortedPoints();
        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 24; y > 0; y--) {
            stringBuilder.append((y % 2 == 0) ? String.format("%2s│", y) : "  │");
            for (int x = 0; x <= 24; x++) {
                final int currentY = y;
                final int currentX = x;
                if (po.stream()
                        .anyMatch(p -> p.getX() == currentX && p.getY() == currentY)) {
                    stringBuilder.append(" * ");
                } else {
                    stringBuilder.append("  ");
                }

            }
            stringBuilder.append("\n");
        }

        stringBuilder.append("  +");

        for (int x = 0; x <= 24; x++) {
            stringBuilder.append("─");
        }

        stringBuilder.append("\n");

        for (int x = 0; x <= 24; x++) {
            stringBuilder.append((x % 2 == 0) ? String.format("%2s", x) : "  ");
        }
//
//
//        for (int i = 0; i < points.size(); i++) {
//            int startPoint = points.getSortedPoints().get(i).getX() + (51-points.getSortedPoints().get(i).getY())*27;
//            stringBuilder.replace(startPoint, startPoint, " *");
//        }

        return stringBuilder.toString();
    }
}
