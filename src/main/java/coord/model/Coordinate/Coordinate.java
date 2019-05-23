package coord.model.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Coordinate {
    private static final int MAX = 24;
    private List<List<String>> coordinates;

    public Coordinate() {
        coordinates = new ArrayList<>();
        IntStream.range(0, MAX + 1).forEach(i -> {
            String[] blanks = new String[MAX + 1];
            IntStream.range(0, MAX + 1).forEach(j -> blanks[j] = "  ");
            coordinates.add(Arrays.asList(blanks));
        });
        mark();
    }

    public void mark() {
        for (int y = 0; y <= MAX; y++) {
            coordinates.get(MAX - y).set(0, String.format("%2s", Integer.toString(y)));
        }
        for (int x = 1; x <= MAX; x++) {
            coordinates.get(MAX).set(x, String.format("%2s", Integer.toString(x)));
        }
    }

    public void print() {
        for (List<String> point : coordinates) {
            System.out.println(point);
        }
    }
}
