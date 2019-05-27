package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointsFactoryTest {
    @Test
    void of_() {
        PointFactory pointFactory = PointFactory.of(0, 10, 0, 10);
        List<Integer> numbers = Arrays.asList(0, 2, 4, 6);
        Points points = Points.from(Arrays.asList(new Point(0, 2), new Point(4, 6)));

        assertThat(PointsFactory.of(pointFactory, numbers));
    }

}