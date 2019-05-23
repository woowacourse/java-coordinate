package coordinate.model;

import coordinate.model.Point;
import coordinate.model.Value;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @Test
    void 포인트_생성_테스트() {

        Point testPoint = new Point(new Value("1"), new Value("2"));
        assertThat(testPoint).isEqualTo(new Point(new Value("1"), new Value("2")));
    }
}
