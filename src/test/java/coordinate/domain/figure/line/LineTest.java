package coordinate.domain.figure.line;

import coordinate.domain.figure.InvalidFigureException;
import coordinate.domain.point.Point;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 라인_생성() {
        Line line = new Line(Arrays.asList(
                new Point(0, 0),
                new Point(1, 1)
        ));
        assertThat(line).isEqualTo(new Line(Arrays.asList(
                new Point(0, 0),
                new Point(1, 1)
        )));
    }

    @Test
    void 라인_생성_시_중복된_점_존재() {
        assertThrows(InvalidFigureException.class, () -> new Line(Arrays.asList(
                new Point(0, 0),
                new Point(0, 0)
        )));
    }

    @Test
    void 라인의_길이_계산() {
        List<Point> point = Arrays.asList(new Point(0, 0), new Point(1, 1));
        Line line = new Line(point);
        assertThat(line.area()).isEqualTo(1.414, Offset.offset(0.001));
    }
}
