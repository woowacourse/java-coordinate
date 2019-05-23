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
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(1, 2), new Coordinate(2, 1),
                new Coordinate(22, 2), new Coordinate(2, 9));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(1, 4), new Coordinate(4, 1),
                new Coordinate(2, 3), new Coordinate(20, 2));
        List<Coordinate> coordinates3 = Arrays.asList(new Coordinate(1, 4), new Coordinate(1, 2),
                new Coordinate(1, 5), new Coordinate(5, 4));

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
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(1, 9), new Coordinate(1, 4),
                new Coordinate(6, 4), new Coordinate(6, 9));
        List<Coordinate> coordinates2 = Arrays.asList(new Coordinate(11, 19), new Coordinate(11, 14),
                new Coordinate(16, 14), new Coordinate(16, 19));

        assertThat(new Rectangle(coordinates).area()).isEqualTo(25, offset(0.00099));
        assertThat(new Rectangle(coordinates2).area()).isEqualTo(25, offset(0.00099));

    }
}