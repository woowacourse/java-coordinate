package coordinate.view;

import coordinate.UserInterface;
import coordinate.domain.Figure;
import coordinate.domain.Line;
import coordinate.domain.Points;

public class OutputView {
    private static final String POLE_HEIGHT = "|";
    private static final String NEW_LINE = "\n";

    public static void printResult(final Figure figure) {
        printCoordinates(figure.getPoints());
        System.out.println(figure.toString() + " 넓이는 " + figure.area());
    }

    public static void printResult(final Line line) {
        printCoordinates(line.getPoints());
        System.out.println("두 점 사이 거리는 " + line.length());
    }

    private static void printCoordinates(final Points points) {
        UserInterface userInterface = new UserInterface();
        userInterface.drawPoints(points);
        StringBuilder sb = new StringBuilder();
        boolean[][] coordinates = userInterface.getCoordinates();

        for (int i = coordinates.length - 1; i >= 0; i--) {
            sb.append(i).append(POLE_HEIGHT);
            for (int j = 0; j < coordinates.length; j++) {
                sb.append(coordinates[j][i] ? "*  " : "   ");
            }
            sb.append(NEW_LINE);
        }
        System.out.println(sb.toString());
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("0     2      4     6      8     10    12    14    16    18    20    22");
    }
}
