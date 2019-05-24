package coord.view;

import coord.model.Figure;
import coord.model.Line;

public class OutputView {


    public static void printLengthOfLine(Line line) {
        System.out.println(lineMessage(line));
    }

    private static String lineMessage(Line line) {
        return "두 점 사이 거리는 " + line.length() + "입니다.";
    }

    public static void printAreaOfFigure(Figure figure) {
        System.out.println(areaMessage(figure));
    }

    private static String areaMessage(Figure figure) {
        return figure.getName() + "의 넓이는 " + figure.area() + "입니다.";
    }
}