package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointsTest {
        @Test
        void Point_중복_검사() {
                List<Point> points = new ArrayList<>();
                points.add(new Point(1, 1));
                points.add(new Point(2, 2));
                points.add(new Point(1, 1));
                assertThrows(IllegalArgumentException.class, () -> {
                        new Points(points);
                });
        }

        @Test
        void 두_점_거리_추출() {
                List<Point> pointList = new ArrayList<>();
                pointList.add(new Point(1, 1));
                pointList.add(new Point(4, 1));
                Points points = new Points(pointList);
                assertThat(points.getDistance(0, 1)).isEqualTo(3);
        }

        @Test
        void 두_점_기울기_추출() {
                List<Point> pointList = new ArrayList<>();
                pointList.add(new Point(1, 1));
                pointList.add(new Point(3, 3));
                Points points = new Points(pointList);
                assertThat(points.getIncline(0, 1)).isEqualTo(1);
        }
}