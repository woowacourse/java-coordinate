package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureTest {
    List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3)));
    Figure figure = new Figure(points);

    @Test
    public void 좌표평면을_잘_그리는지_확인() {
        assertThat(figure.drawPlane()).isEqualTo("");
    }
}