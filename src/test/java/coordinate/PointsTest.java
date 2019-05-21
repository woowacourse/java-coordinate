package coordinate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {
    @Test
    void nullArgumentTest() {
        assertThrows(IllegalArgumentException.class, () -> new Points(null));
    }

    @Test
    void sortByXTest() {

    }

    @Test
    void sortByYTest() {

    }

    @Test
    void getElementByIndexTest() {
        Points points = new Points(Arrays.asList(new Point(0, 0),
                new Point(5,0), new Point(5, 3),
                new Point(0, 3)));
    }
}
