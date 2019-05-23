package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author soojinroh
 * @version 1.0 2019-05-21
 */
public class CoordinateTest {

    Coordinate coordinate;

    @BeforeEach
    void setUp() {
        coordinate = Coordinate.create(10,15);
    }

    @Test
    void create_생성() {
        assertThat(coordinate).isEqualTo(Coordinate.create(10,15));
    }

    @Test
    void matchYAxis_y값_일치_확인() {
        int xCoordinate = coordinate.matchYAxis(15);
        assertThat(xCoordinate).isEqualTo(10);
    }

    @Test
    void matchYAxis_y값_불일치_확인() {
        int xCoordinate = coordinate.matchYAxis(14);
        assertThat(xCoordinate).isEqualTo(-1);
    }

    @Test
    void create_x값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            Coordinate.create(-1, 10);
        });
    }

    @Test
    void create_y값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            Coordinate.create(10, 25);
        });
    }
}
