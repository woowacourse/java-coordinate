package coordinate.domain.figure.triangle;

import coordinate.domain.figure.InvalidAbstractFigureException;
import coordinate.domain.point.Point;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 삼각형_생성() {
        Triangle triangle = new Triangle(Arrays.asList(
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 0)
        ));
        assertThat(triangle).isNotNull();
    }

    @Test
    void 삼각형_생성_시_중복된_점_생성불가() {
        assertThrows(InvalidAbstractFigureException.class, () -> {
            new Triangle(Arrays.asList(
                    new Point(0, 0),
                    new Point(0, 1),
                    new Point(0, 0)
            ));
        });
    }

    @Test
    void 삼각형이_아닌_경우() {
        assertThrows(InvalidTriangleException.class, () -> {
            new Triangle(Arrays.asList(
                    new Point(0, 1),
                    new Point(1, 2),
                    new Point(2, 3)
            ));
        });
    }

    @Test
    void 직각삼각형_면적_계산() {
        Triangle triangle = new Triangle(Arrays.asList(
                new Point(0, 0),
                new Point(0, 2),
                new Point(2, 0)
        ));
        assertThat(triangle.area()).isEqualTo(2, Offset.offset(0.1));
    }

    @Test
    void 삼각형_면적_계산() {
        Triangle triangle = new Triangle(Arrays.asList(
                new Point(1, 1),
                new Point(2, 2),
                new Point(4, 3)
        ));
        assertThat(triangle.area()).isEqualTo(0.5, Offset.offset(0.1));
    }
}