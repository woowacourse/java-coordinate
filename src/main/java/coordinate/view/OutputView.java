package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final int MAX = 24;
    private static List<List<String>> coordinates;

    static {
        coordinates = new ArrayList<>();
        IntStream.range(0, MAX + 1).forEach(i -> {
            List<String> blanks = new ArrayList<>(Arrays.asList(new String[MAX + 1]));
            IntStream.range(0, MAX + 1).forEach(j -> blanks.set(j, "   "));
            coordinates.add(blanks);
        });

        for (int y = 0; y <= MAX; y++) {
            coordinates.get(MAX - y).set(0, String.format("%3s", Integer.toString(y)));
        }
        for (int x = 1; x <= MAX; x++) {
            coordinates.get(MAX).set(x, String.format("%3s", Integer.toString(x)));
        }
    }

    public static void print(Figure figure) {
        mark(figure);
        show();
        System.out.println(figure.toString());
    }

    private static void show() {
        for (List<String> coordinate : coordinates) {
            System.out.println(coordinate);
        }
    }

    private static void mark(Figure figure) {
        for (Point point : figure.points()) {
            coordinates.get(MAX - point.y()).set(point.x(), String.format("%3s", " * "));
        }
    }
}
