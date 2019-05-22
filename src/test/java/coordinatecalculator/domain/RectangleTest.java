package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    void 직사각형이_아니라고_판단하는지_테스트() {
        /* Given */
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(1, 0), new Coordinate(0, 1),
                new Coordinate(22, 2), new Coordinate(2, 1));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(1, 0), new Coordinate(0, 1),
                new Coordinate(2, 3), new Coordinate(25, 2));
        List<Coordinate> coordinates3 = Arrays.asList(new Coordinate(1, 0), new Coordinate(1, 0),
                new Coordinate(1, 0), new Coordinate(1, 0));

        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(coordinates);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(coordinates2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(coordinates3);
        });
    }

    @Test
    void 넓이를_제대로_구하는지_테스트() {
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(1, 0), new Coordinate(0, 1),
                new Coordinate(1, 2), new Coordinate(2, 1));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(1, 0), new Coordinate(0, 1),
                new Coordinate(2, 3), new Coordinate(3, 2));

        assertThat(new Rectangle(coordinates).area()).isEqualTo(2, offset(0.00099));
        assertThat(new Rectangle(coordinates2).area()).isEqualTo(4, offset(0.00099));

    }
}