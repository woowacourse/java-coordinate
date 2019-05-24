package coordinatecalculator.factory;

import coordinatecalculator.domain.Coordinate;
import coordinatecalculator.domain.Line;
import coordinatecalculator.domain.Rectangle;
import coordinatecalculator.domain.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeMakerTest {
    @Test
    void 좌표의_개수에_따라서_모양이_제대로_나오는지_테스트() {
        /* Given */
        List<Coordinate> coordinates1 = Arrays.asList(new Coordinate(1, 1), new Coordinate(1, 2),
                new Coordinate(2, 1), new Coordinate(2, 2));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(2, 1), new Coordinate(1, 2),
                new Coordinate(23, 3));
        List<Coordinate> coordinates3 = Arrays.asList(new Coordinate(2, 1), new Coordinate(1, 24));

        /* Then */
        assertThat(ShapeMaker.createShape(coordinates1)).isEqualTo(new Rectangle(coordinates1));
        assertThat(ShapeMaker.createShape(coordinates2)).isEqualTo(new Triangle(coordinates2));
        assertThat(ShapeMaker.createShape(coordinates3)).isEqualTo(new Line(coordinates3));
    }

    @Test
    void 좌표의_개수가_이상하면_예외를_던지는지_테스트() {
        /* Given */
        List<Coordinate> coordinates1 = Collections.singletonList(new Coordinate(1, 1));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(1, 14), new Coordinate(14, 1),
                new Coordinate(1, 2), new Coordinate(2, 1), new Coordinate(2, 2));

        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeMaker.createShape(coordinates1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeMaker.createShape(coordinates2);
        });
    }
}