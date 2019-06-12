package coordinate.domain.figure.rectangle;

import coordinate.domain.figure.InvalidAbstractFigureException;
import coordinate.domain.point.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 직사각형_생성() {
        Rectangle rectangle = new Rectangle(Arrays.asList(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(1, 0)
        ));
        assertThat(rectangle).isNotNull();
    }

    @Test
    void 직사각형_생성_시_중복된_점_존재() {
        assertThrows(InvalidAbstractFigureException.class, () -> new Rectangle(Arrays.asList(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(0, 0)
        )));
    }

    @Test
    void 직사각형이_아닌_경우() {
        assertThrows(InvalidRectangleException.class, () -> new Rectangle(Arrays.asList(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(1, 2)
        )));
    }

    @Test
    void 직사각형_넓이() {
        Rectangle rectangle = new Rectangle(Arrays.asList(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(1, 0)
        ));
        assertThat(rectangle.area()).isEqualTo(1);
    }
}
