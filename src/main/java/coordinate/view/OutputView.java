package coordinate.view;

import coordinate.UI;
import coordinate.domain.Figure;
import coordinate.domain.Points;

public class OutputView {
    private static final String POLE_HEIGHT = "|";
    private static final String NEW_LINE = "\n";

    public static void printResult(final Figure figure) {
        printCoordinates(figure.getPoints());
        System.out.println(figure.getName() + " 넓이는 " + figure.area());
    }

    private static void printCoordinates(final Points points) {
        UI ui = new UI(points);
        boolean[][] coordinates = ui.getCoordinates();

        StringBuilder sb = new StringBuilder();
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
