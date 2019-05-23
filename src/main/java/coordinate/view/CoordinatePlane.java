package coordinate.view;

import coordinate.domain.Point;

import java.util.Set;

public class CoordinatePlane {
    boolean[][] plane = new boolean[25][25];

    public CoordinatePlane(Set<Point> points) {
        for (int i=0; i<25; i++) {
            for (int j=0; j<25; j++) {
                plane[i][j] = false;
            }
        }

        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();

            plane[24-y][x] = true;
        }
    }

    public void printPlane() {
        for (int i=0; i<25; i++) {
            System.out.print(i % 2 == 0 ? String.format("%2d", 24-i) : "  ");
            System.out.print("|");
            for (int j=0; j<25; j++) {
                System.out.print(plane[i][j] ? String.format("%3s", "*") : String.format("%3s", " "));
            }
            System.out.println();
        }
        System.out.println("  +------------------------------------------------------------------------------");
        System.out.print("   ");
        for (int i=0; i<25; i++ ) {
            System.out.print(i % 2 == 0 ? String.format("%3d", i) : String.format("%3s", " "));
        }
        System.out.println();
    }
}
