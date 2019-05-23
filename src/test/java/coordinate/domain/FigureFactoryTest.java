package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureFactoryTest {
    FigureFactory factory;

    @BeforeEach
    void setup() {
        factory = new FigureFactory();
    }

    @Test
    void createRectangleTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 0),
                new Point(1, 1),
                new Point(0, 1)
        );
        assertThat(factory.create(points) instanceof Rectangle).isTrue();
    }

    @Test
    void createTriangleTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 0),
                new Point(1, 1)
        );
        assertThat(factory.create(points) instanceof Triangle).isTrue();
    }

    @Test
    void createLineTest() {
        List<Point> points = Arrays.asList(
                new Point(0, 0),
                new Point(1, 0)
        );
        assertThat(factory.create(points) instanceof Line).isTrue();
    }
}
