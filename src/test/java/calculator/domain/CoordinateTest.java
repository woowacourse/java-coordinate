package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class CoordinateTest {

    Coordinate coordinate;

    @BeforeEach
    void setUp() {
        coordinate = new Coordinate(10,15);
    }

    @Test
    void create_생성() {
        assertThat(coordinate).isEqualTo(new Coordinate(10,15));
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
            new Coordinate(-1, 10);
        });
    }

    @Test
    void create_y값_범위_초과_예외처리() {
        assertThrows(IllegalArgumentException.class, () ->{
            new Coordinate(10, 25);
        });
    }
}
