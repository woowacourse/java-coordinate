package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void rectangleNotCreateTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(
                new Lines(Arrays.asList(
                new Line(new Point(0, 0), new Point(5, 0)),
                new Line(new Point(5, 0), new Point(5, 1)),
                new Line(new Point(5, 1), new Point(0, 2)),
                new Line(new Point(0, 2), new Point(0, 0)))))
        );
    }

    @Test
    void rectangleCreateTest() {
        Rectangle rectangle = new Rectangle(
                new Lines(Arrays.asList(
                        new Line(new Point(10, 10), new Point(22, 10)),
                        new Line(new Point(22, 18), new Point(22, 10)),
                        new Line(new Point(22, 18), new Point(10, 18)),
                        new Line(new Point(10, 18), new Point(10, 10)))));
        assertThat(rectangle).isNotNull();
    }

    @Test
    void calculateParallelRectangleAreaTest() {
        Lines lines = new Lines(Arrays.asList(
                new Line(new Point(0, 0), new Point(5, 0)),
                new Line(new Point(5, 0), new Point(5, 2)),
                new Line(new Point(5, 2), new Point(0, 2)),
                new Line(new Point(0, 2), new Point(0, 0))));
        Rectangle rectangle = new Rectangle(lines);
        List<Double> lineDistance = rectangle.createTriangle();
        assertThat(rectangle.area(lineDistance)).isEqualTo(10, Offset.offset(0.001));
    }

    @Test
    void calculateTiledRectangleAreaTest() {
        Lines lines = new Lines(Arrays.asList(
                new Line(new Point(1, 0), new Point(2, 1)),
                new Line(new Point(2, 1), new Point(1, 2)),
                new Line(new Point(1, 2), new Point(0, 1)),
                new Line(new Point(0, 1), new Point(1, 0))));
        Rectangle rectangle = new Rectangle(lines);
        List<Double> lineDistance = rectangle.createTriangle();
        assertThat(rectangle.area(lineDistance)).isEqualTo(2, Offset.offset(0.001));
    }
}

