package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    Line line;
    @BeforeEach
    void setUp() {
        List<Point> points = new ArrayList<>();
        points.add(new Point("10","10"));
        points.add(new Point("14","15"));
        Coordinate coordinate = new Coordinate(points);
        line = new Line(coordinate);
    }

    @Test
    void 길이구하기() {
        assertEquals(6.403,line.findArea(),0.001);
    }
}
