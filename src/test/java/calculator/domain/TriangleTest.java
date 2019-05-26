package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author soojinroh
 * @version 1.0 2019-05-23
 */
public class TriangleTest {

    Figure triangle;
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        coordinates = new Coordinates();
        coordinates.add(new Coordinate(0 ,0));
        coordinates.add(new Coordinate(10 ,0));
        coordinates.add(new Coordinate(5 ,10));
        triangle = FigureFactory.getInstance().create(coordinates);
    }

    @Test
    void create_생성_확인() {
        assertThat(triangle).isEqualTo(FigureFactory.getInstance().create(coordinates));
    }

    @Test
    void area_삼각형_넓이_확인() {
        assertThat(triangle.area()).isEqualTo(50.000,offset(0.00099));
    }

    @Test
    void checkTriangle_일직선_확인() {
        coordinates = new Coordinates();
        coordinates.add(new Coordinate(0 ,0));
        coordinates.add(new Coordinate(0 ,5));
        coordinates.add(new Coordinate(0,10));
        assertThrows(IllegalArgumentException.class, () -> {
            FigureFactory.getInstance().create(coordinates);
        });
    }
}
