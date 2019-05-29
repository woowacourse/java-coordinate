package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointsFactoryTest {
    @Test
    void of_() {
        PointsFactory pointsFactory = PointsFactory.from(DefaultPoint::new);
        List<Integer> numbers = Arrays.asList(0, 2, 4, 6);
        Points points = Points.from(Arrays.asList(new DefaultPoint(0, 2), new DefaultPoint(4, 6)));

        assertThat(pointsFactory.createFromNumbers(numbers)).isEqualTo(points);
    }
}