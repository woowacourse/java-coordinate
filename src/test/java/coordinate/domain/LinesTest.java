package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinesTest {
    @Test
    void duplicateLinesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lines(Arrays.asList(
                new Line(new Point(0, 0), new Point(0, 1)),
                new Line(new Point(0, 1), new Point(0, 0))
        )));
    }
}
