package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class TriangleTest {

    Figure triangle;
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        coordinates = new Coordinates();
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(10, 0));
        coordinates.add(new Coordinate(5, 10));
        triangle = new FigureFactory().create(coordinates);
    }

    @Test
    void create_생성_확인() {
        assertThat(triangle).isEqualTo(new FigureFactory().create(coordinates));
    }

    @Test
    void area_삼각형_넓이_확인() {
        assertThat(triangle.area()).isEqualTo(50.000, offset(0.00099));
    }
}
