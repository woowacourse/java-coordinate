package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class PointsTest {
    Coordinates points;

    @BeforeEach
    void setUp() {
        points = new Coordinates();
        points.add(Coordinate.create(10,20));
        points.add(Coordinate.create(10,10));
    }

    @Test
    void create_생성() {
        assertThat(points.size()).isEqualTo(2);
    }

    @Test
    void add_중복_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            points.add(Coordinate.create(10,10));
        });
    }

    @Test
    void add_추가_갯수_확인() {
        points.add(Coordinate.create(3,17));
        points.add(Coordinate.create(9,21));

        assertThrows(IllegalArgumentException.class, () -> {
            points.add(Coordinate.create(1,1));
        });
    }
}
