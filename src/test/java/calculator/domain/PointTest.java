package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class PointTest {

    Point point;

    @BeforeEach
    void setUp() {
        point = Point.create(10,15);
    }

    @Test
    void create_생성() {
        assertThat(point).isEqualTo(Point.create(10,15));
    }

    @Test
    void matchYAxis_y값_일치_확인() {
        int xCoordinate = point.matchYAxis(15);
        assertThat(xCoordinate).isEqualTo(10);
    }

    @Test
    void matchYAxis_y값_불일치_확인() {
        int xCoordinate = point.matchYAxis(14);
        assertThat(xCoordinate).isEqualTo(-1);
    }

    @Test
    void create_x값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            Point.create(-1, 10);
        });
    }

    @Test
    void create_y값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            Point.create(10, 25);
        });
    }
}
