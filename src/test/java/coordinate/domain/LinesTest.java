package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinesTest {
    @Test
    void nullTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lines(null));
    }

    @Test
    void nullListTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lines(Arrays.asList(null, null)));
    }

    @Test
    void duplicatedLinesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Lines(Arrays.asList(
                new Line(new Point(0, 0), new Point(0, 1)),
                new Line(new Point(0, 0), new Point(0, 1))
        )));
    }

    @Test
    void getLineIndexUnderflowTest() {
        Lines lines = new Lines(Arrays.asList(new Line(new Point(0, 0), new Point(0, 1))));
        assertThrows(IllegalArgumentException.class, () -> lines.getVector(-1));
    }

    @Test
    void getLineIndexOverflowTest() {
        Lines lines = new Lines(Arrays.asList(new Line(new Point(0, 0), new Point(0, 1))));
        assertThrows(IllegalArgumentException.class, () -> lines.getVector(2));
    }

    @Test
    void isVerticalTest() {
        Lines lines = new Lines(Arrays.asList(
                new Line(new Point(0, 0), new Point(1, 1)),
                new Line(new Point(0, 1), new Point(1, 0))
        ));
        assertThat(lines.isOrthogonal(0, 1)).isTrue();
    }
}
