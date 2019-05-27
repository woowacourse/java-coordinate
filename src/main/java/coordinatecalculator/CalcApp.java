package coordinatecalculator;

public class CalcApp {
    public static void main(String[] args) {
        try {
            Figure fig = FigureFactory.of(Input.points());
            System.out.println(fig);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
