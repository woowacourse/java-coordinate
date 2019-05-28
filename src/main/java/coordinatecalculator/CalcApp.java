package coordinatecalculator;

public class CalcApp {
    public static void main(String[] args) {
        //        try {
        //            Figure fig = FigureFactory.of(Input.points());
        //            System.out.println(fig);
        //        } catch (IllegalArgumentException e) {
        //            System.out.println(e.getMessage());
        //        }
        //        SingleLine s = new SingleLine(8, 24, 12, true);
        //        s.write(23, Board.POINT);
        //        System.out.println(s.makeString());
        Point p0 = Point.of(1, 1);
        Point p1 = Point.of(2, 2);
        Point p2 = Point.of(4, 4);
        Point p3 = Point.of(12, 12);
        Point p4 = Point.of(24, 24);
        Board board = new Board();
        board.setPoint(p0);
        board.setPoint(p1);
        board.setPoint(p2);
        board.setPoint(p3);
        board.setPoint(p4);
        //        String axis = " 0    2   4   6   8  10  12  14  16  18  20  22  24";
        System.out.println(board.getString());
        //        System.out.println(axis);
    }
}
