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
        point = new Point(10,15);
    }

    @Test
    void create_생성() {
        assertThat(point).isEqualTo(new Point(10,15));
    }

    @Test
    void create_x값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Point(-1, 10);
        });
    }

    @Test
    void create_y값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Point(10, 25);
        });
    }
}
