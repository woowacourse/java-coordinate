package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    void 길이() {
        Line line = new Line(Arrays.asList(new Point(1, 10), new Point(1, 1)));
        assertEquals(9.0, line.length(), 0.1);
    }
}