package coord.view;

import coord.model.Point;
import coord.model.Points;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CoordinateView {
    private static final int MAX = 24;
    private List<List<String>> coordinates;

    public CoordinateView(Points points) {
        coordinates = new ArrayList<>();
        IntStream.range(0, MAX + 1).forEach(i -> {
            List<String> blanks = new ArrayList<>(Arrays.asList(new String[MAX + 1]));
            IntStream.range(0, MAX + 1).forEach(j -> blanks.set(j, "   "));
            coordinates.add(blanks);
        });
        draw();
        mark(points);
    }

    private void draw() {
        for (int y = 0; y <= MAX; y++) {
            coordinates.get(MAX - y).set(0, String.format("%3s", Integer.toString(y)));
        }
        for (int x = 1; x <= MAX; x++) {
            coordinates.get(MAX).set(x, String.format("%3s", Integer.toString(x)));
        }
    }

    private void mark(Points points) {
        for (Point point : points.getPoints()) {
            coordinates.get(MAX - point.y).set(point.x, String.format("%3s", " * "));
        }
    }

    public void print() {
        for (List<String> point : coordinates) {
            System.out.println(point);
        }
    }
}
