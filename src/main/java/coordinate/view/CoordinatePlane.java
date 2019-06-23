package coordinate.view;

import coordinate.domain.Point;

import java.util.Set;

public class CoordinatePlane {
    private static final int X_MAX = 25;
    private static final int Y_MAX = 25;
    private static final int X_MIN = 0;
    private static final int Y_MIN = 0;
    public static final int X_AXIS = 78;
    boolean[][] plane = new boolean[X_MAX][Y_MAX];

    public CoordinatePlane(Set<Point> points) {
        for (int i = X_MIN; i < X_MAX; i++) {
            for (int j = Y_MIN; j < Y_MAX; j++) {
                plane[i][j] = false;
            }
        }

        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();

            plane[Y_MAX - 1 - y][x] = true;
        }
    }

    public void printPlane() {
        for (int i = Y_MIN; i < Y_MAX; i++) {
            System.out.print(i % 2 == 0 ? String.format("%2d", Y_MAX - 1 - i) : "  ");
            System.out.print("|");
            for (int j = X_MIN; j < X_MAX; j++) {
                System.out.print(plane[i][j] ? String.format("%3s", "*") : String.format("%3s", " "));
            }
            System.out.println();
        }

        System.out.print("  +");
        for (int i = 0; i < X_AXIS; i++) {
            System.out.print("-");
        }
        System.out.println();

        System.out.print("   ");
        for (int i = X_MIN; i < X_MAX; i++) {
            System.out.print(i % 2 == 0 ? String.format("%3d", i) : String.format("%3s", " "));
        }
        System.out.println();
    }
}
