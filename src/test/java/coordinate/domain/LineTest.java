package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {
    private Line line;

    @BeforeEach
    public void setUp() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2)));
        line = new Line(points);
    }

    @Test
    public void Point가_2개_이상_들어올_경우() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3)));

        assertThatThrownBy(() -> {
            new Line(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void lengthTest() {
        assertThat(line.length()).isEqualTo(1.414, offset(0.00099));
    }
}
