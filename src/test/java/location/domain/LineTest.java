package location.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 동일한_점_일때() {
        assertThrows(IllegalArgumentException.class, () -> new Line(new Point(10, 10), new Point(10, 10)));
    }

    @Test
    void 거리계산() {
        Line line = new Line(new Point(10, 10), new Point(10, 20));
        assertThat(line.calculateLine()).isEqualTo(10);
    }

    @Test
    void 계산(){
        List<Point> points = new ArrayList<>();
        points.add(new Point(5, 3));
        points.add(new Point(20,5));
        points.add(new Point(10, 5));
        points.add(new Point(15, 3));

        for (Point point : points) {
            System.out.println(point.getX() +" : " +point.getY());
        }
    }
}
