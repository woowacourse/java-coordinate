package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    private Points points;

    @BeforeEach
    void setUp() {
        points = Points.create();
    }

    @Test
    void 두_점을_가지고_있는_Line_생성() {
        points.addPoint(Point.create(1, 4));
        points.addPoint(Point.create(2, 6));

        Line line = Line.create(points);
        assertThat(line).isEqualTo(Line.create(points));
    }

    @Test
    void 두_점사이의_거리_계산() {
        points.addPoint(Point.create(4, 5));
        points.addPoint(Point.create(6, 7));

        Line line = Line.create(points);
        assertThat(line.calculateDistance()).isEqualTo(2.828427, offset(0.00099));
    }

    @Test
    void 점이_하나밖에_없을때() {
        points.addPoint(Point.create(4, 5));

        assertThrows(IllegalArgumentException.class, () -> {
            Line.create(points);
        });
    }

    @Test
    void 한점이_null() {
        points.addPoint(null);
        points.addPoint(Point.create(4, 5));

        Line line = Line.create(points);
        assertThrows(NullPointerException.class, line::calculateDistance);
    }
}
