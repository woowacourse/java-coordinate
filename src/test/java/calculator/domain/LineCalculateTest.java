package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
class LineCalculateTest {

    Calculate shape;
    Coordinates points;

    @BeforeEach
    void setUp() {
        points = new Coordinates();
        points.add(Coordinate.create(8,21));
        points.add(Coordinate.create(16,3));
        shape = FigureFactory.getInstance().create(points);
    }

    @Test
    void create_계산_정답() {
        assertThat(shape.calculate()).isEqualTo(19.697,offset(0.00099));
    }

    @Test
    void line_계산_반올림_확인() {
        assertThat(shape.calculate()).isEqualTo(19.698,offset(0.00099));
    }
}