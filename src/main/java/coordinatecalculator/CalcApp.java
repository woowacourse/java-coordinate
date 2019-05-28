package coordinatecalculator;

public class CalcApp {
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        Figure figure = tryInput();
        Board board = new Board(figure);
        System.out.println(NEW_LINE + board.getString() + NEW_LINE);
        System.out.println(figure);
    }

    private static Figure tryInput() {
        Figure figure;
        try {
            figure = FigureFactory.of(Input.points());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return tryInput();
        }
        return figure;
    }
}
