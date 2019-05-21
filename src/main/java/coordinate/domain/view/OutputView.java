package coordinate.domain.view;

public class OutputView {
    public static void printCoordinate() {
        String[][] coordinatePlane = new String[25][25];
        for (int i = 24; i >= 0; i -= 2) {
            System.out.print(i + "|");
            for (int j = 0; j <= 24; j++) {
           //     System.out.print();
            }
            System.out.println("  |");
        }
    }
}
