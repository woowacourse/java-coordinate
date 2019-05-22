package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 반듯한_사각형() {
        List<Line> lines = Arrays.asList(
                new Line(Point.create(1,1), Point.create(4,1)),
                new Line(Point.create(4,1), Point.create(4,3)),
                new Line(Point.create(4,3), Point.create(1,3)),
                new Line(Point.create(1,3), Point.create(1,1))
        );
        Rectangle rectangle = new Rectangle(lines);
        assertThat(rectangle.area()).isEqualTo(6);
    }

    @Test
    void 기울어진_사각형() {
        List<Line> lines = Arrays.asList(
                new Line(Point.create(1,3), Point.create(2,2)),
                new Line(Point.create(2,2), Point.create(3,3)),
                new Line(Point.create(3,3), Point.create(2,4)),
                new Line(Point.create(2,4), Point.create(1,3))
        );
        Rectangle rectangle = new Rectangle(lines);

        assertEquals(2.0, rectangle.area(), 0.001);
    }

    @Test
    void 직사각형아닌경우() {
        List<Line> lines = Arrays.asList(
                new Line(Point.create(1,1), Point.create(4,1)),
                new Line(Point.create(4,1), Point.create(5,3)),
                new Line(Point.create(5,3), Point.create(1,3)),
                new Line(Point.create(1,3), Point.create(1,1))
        );
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(lines);
        });
    }

}


