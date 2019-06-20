package coordinatecalculator;

import coordinatecalculator.model.Figure;
import coordinatecalculator.model.FigureFactory;
import coordinatecalculator.model.Point;
import coordinatecalculator.view.Board;
import coordinatecalculator.view.Input;

import java.util.ArrayList;
import java.util.List;

public class CalcApp {
    private static final String NEW_LINE = "\n";
    private static final String MSG_FORM_POINTS
            = "좌표 값은 괄호로 둘러져 있어야 하며, 쉼표로 구분되어야 합니다.";

    public static void main(String[] args) {
        Figure figure = inputPoints();
        Board board = new Board(figure);
        System.out.println(NEW_LINE + board.getString() + NEW_LINE);
        System.out.println(figure);
    }

    private static Figure inputPoints() {
        List<Point> points = tryInputPoints();
        while (points == null) {
            System.err.println(MSG_FORM_POINTS);
            points = tryInputPoints();
        }
        return FigureFactory.of(points);
    }

    private static List<Point> parsePoints(List<String> input) {
        List<Point> result = new ArrayList<>();
        try {
            for (int i = 0, x, y; i < input.size(); i += 2) {
                x = Integer.parseInt(input.get(i));
                y = Integer.parseInt(input.get(i + 1));
                result.add(new Point(x, y));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(MSG_FORM_POINTS);
        }
        return result;
    }

    private static List<Point> tryInputPoints() {
        try {
            return parsePoints(Input.inputPoints());
        } catch (Exception e) {
            return null;
        }
    }
}
