package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    private FigureFactory factory;

    @BeforeEach
    void setup() {
        factory = new FigureFactory();
    }

    @Test
    void linesSizeNotThreeTest() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(
                new Lines(Arrays.asList(
                        new Line(new Point(0, 0), new Point(0, 1)),
                        new Line(new Point(0, 1), new Point(1, 0))
                ))
        ));
    }

    @Test
    void triangleAreaTest() {
        Triangle triangle = (Triangle) factory.create(Arrays.asList(
                new Point(0, 0), new Point(2, 0), new Point(0, 2)
        ));

        assertThat(triangle.area()).isEqualTo(2.0, Offset.offset(0.001));
    }

    @Test
    void triangleParallelLinesTest() {
        assertThrows(IllegalArgumentException.class, () -> factory.create(Arrays.asList(
                new Point(1, 1), new Point(2, 2), new Point(3, 3)
        )));
    }
}
