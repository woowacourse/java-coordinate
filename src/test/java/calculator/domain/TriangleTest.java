package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

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
        coordinates.add(Coordinate.create(0 ,0));
        coordinates.add(Coordinate.create(10 ,0));
        coordinates.add(Coordinate.create(5 ,10));
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
}
