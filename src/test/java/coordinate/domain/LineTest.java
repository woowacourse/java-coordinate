package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 두_점을_가지고_있는_Line_생성() {
        Line line = Line.create(Point.create(1, 4), Point.create(2, 6));
        assertThat(line).isEqualTo(Line.create(Point.create(1, 4), Point.create(2, 6)));
    }

    @Test
    void 두_점사이의_거리_계산() {
        Line line = Line.create(Point.create(4, 5), Point.create(6, 7));
        assertThat(line.calculateDistance()).isEqualTo(2.828427, offset(0.00099));
    }

    @Test
    void 점이_하나밖에_없을때() {
        assertThrows(IllegalArgumentException.class, () -> {
            Line line = Line.create(null, Point.create(4, 5));
        });
    }
}
