package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author heebg
 * @version 1.0 2019-05-27
 */
class FigureFactoryTest {
    Points points;

    @BeforeEach
    void setUp() {
        points = new Points();
        points.add(new Point(new Coordinate(0),new Coordinate(0)));
        points.add(new Point(new Coordinate(1),new Coordinate(0)));
        points.add(new Point(1,10));
    }

    @Test
    void create_예외_1개() {
        Points exPoints = new Points();
        exPoints.add(new Point(1,1));
        assertThrows(IllegalArgumentException.class, () -> {
            new FigureFactory().create(FigureType.valueOf(exPoints));
        });
    }

    @Test
    void create_4각형_초과_예외_확인() {
        points.add(new Point(20,10));
        points.add(new Point(2,1));
        assertThrows(Exception.class, () -> {
            new FigureFactory().create(FigureType.valueOf(points));
        });
    }
}