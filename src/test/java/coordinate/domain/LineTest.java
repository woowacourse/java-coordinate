package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 중복된_점_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(Point.create(1, 1), Point.create(1, 1));
        });
    }

    @Test
    void 라인_길이() {
        Point point1 = Point.create(6, 3);
        Point point2 = Point.create(9, 7);
        Line line = new Line(point1, point2);
        assertEquals(5.0, line.length(), 0.1);
    }

    @Test
    void 직교라인_성공() {
        Line line1 = new Line(Point.create(1, 3), Point.create(2, 4));
        Line line2 = new Line(Point.create(2, 4), Point.create(3, 3));
        assertThat(line1.orthogonalTo(line2)).isTrue();
    }

    @Test
    void 직교라인_실패() {
        Line line1 = new Line(Point.create(1, 3), Point.create(2, 4));
        Line line2 = new Line(Point.create(2, 4), Point.create(2, 2));
        assertThat(line1.orthogonalTo(line2)).isFalse();

    }
}
