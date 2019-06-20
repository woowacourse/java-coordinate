package coordinatecalculator;

import coordinatecalculator.model.Line;
import coordinatecalculator.model.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void toString1() {
        String expected = "두 점 사이의 거리는 12.728입니다.";
        Point p1 = new Point(1, 1);
        Point p2 = new Point(10, 10);
        Line line = Line.of(p1, p2);
        assertThat(line.toString()).isEqualTo(expected);
    }
}