package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointsTest {
    @Test
    void create() {
        Points points = new Points(Arrays.asList(new Point("1", "2"), new Point("2", "2")));
        assertEquals(points, new Points(Arrays.asList(new Point("1", "2"), new Point("2", "2"))));
    }
}
