package coord.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointsTest {
    @Test
    void sortTest() {
        Points points = new Points(Arrays.asList(new Point(1, 3), new Point(4, 21), new Point(8, 21)));
        assertEquals(Arrays.asList(new Point(4, 21), new Point(8, 21), new Point(1, 3)), points.getPoints());
    }
}