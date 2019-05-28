package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class TriangleTest {

    AbstractFigure triangle;
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
    void create_일직선_예외_확인() {
        Coordinates exCoordinates = new Coordinates();
        exCoordinates.add(new Coordinate(0,0));
        exCoordinates.add(new Coordinate(1,1));
        exCoordinates.add(new Coordinate(2,2));
        assertThrows(Exception.class, () -> {
            new FigureFactory().create(exCoordinates);
        });
    }

    @Test
    void area_삼각형_넓이_확인() {
        assertThat(triangle.area()).isEqualTo(50.000, offset(0.00099));
    }
}
