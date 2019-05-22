package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
class LineTestCalculateTest {

    ShapeCalculate shape;
    Points points;

    @BeforeEach
    void setUp() {
        points = new Points();
        points.add(Point.create(8,21));
        points.add(Point.create(16,3));
        shape = ShapeCalculateFactory.getInstance().create(points);
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