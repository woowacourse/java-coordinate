package coordinatecalculator;

public class CalcApp {
    public static void main(String[] args) {
        Figure figure = FigureFactory.of(Input.points());
        Board board = new Board(figure);
        System.out.println(); // 빈 줄 추가.
        System.out.println(board.getString());
        System.out.println(); // 빈 줄 추가.
        System.out.println(figure);
    }
}
