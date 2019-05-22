package coordinate.domain;

import org.junit.jupiter.api.Test;

import javax.annotation.PostConstruct;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void Point_생성() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Point(25, 0);
        });
    }

    @Test
    void 두점_사이의_거리() {
        Point pointOne = new Point(10,10);
        Point pointTwo = new Point(14,15);

        double actualResult = pointOne.getDistance(pointTwo);

        assertThat(actualResult).isEqualTo(6.4031,offset(0.00099));
    }
}
