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
    Points points;

    @BeforeEach
    void setUp() {
        points = new Points();
        points.add(new Point(new Coordinate(10),new Coordinate(10)));
        points.add(new Point(new Coordinate(10),new Coordinate(20)));
        points.add(new Point(new Coordinate(5),new Coordinate(4)));

    }

    @Test
    void create_생성() {
        assertThat(points.size()).isEqualTo(3);
    }

    @Test
    void add_중복_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            points.add(new Point(new Coordinate(10),new Coordinate(10)));
        });
    }

    @Test
    void comparable_테스트_1() {
        assertThat(points.get(0)).isEqualTo(new Point(new Coordinate(10),new Coordinate(20)));
    }

    @Test
    void comparable_테스트_2() {
        assertThat(points.get(1)).isEqualTo(new Point(new Coordinate(10),new Coordinate(10)));
    }

    @Test
    void comparable_테스트_3() {
        assertThat(points.get(2)).isEqualTo(new Point(new Coordinate(5),new Coordinate(4)));
    }
}
