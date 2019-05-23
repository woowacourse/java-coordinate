package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
class LineTest {

    Figure figure;
    Coordinates coordinates;

    @BeforeEach
    void setUp() {
        coordinates = new Coordinates();
        coordinates.add(Coordinate.create(8,21));
        coordinates.add(Coordinate.create(16,3));
        figure = FigureFactory.getInstance().create(coordinates);
    }

    @Test
    void create_계산_정답() {
        assertThat(figure.area()).isEqualTo(19.697,offset(0.00099));
    }

    @Test
    void line_계산_반올림_확인() {
        assertThat(figure.area()).isEqualTo(19.698,offset(0.00099));
    }
}