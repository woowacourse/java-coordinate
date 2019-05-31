package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PointsFactoryTest {
    @Test
    void of_() {
        PointsFactory pointsFactory = PointsFactory.from(DefaultPoint::new);
        List<Integer> numbers = Arrays.asList(0, 2, 4, 6);
        Points points = Points.from(Arrays.asList(DefaultPoint.ofInts(0, 2), DefaultPoint.ofInts(4, 6)));

        assertThat(pointsFactory.createFromNumbers(numbers)).isEqualTo(points);
    }
}