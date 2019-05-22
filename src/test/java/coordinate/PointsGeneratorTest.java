package coordinate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointsGeneratorTest {

    @Test
    void 포인트_생성_테스트() {
        List<Point> testPoints = Arrays.asList(new Point(new Value("1"), new Value("2")),
                new Point(new Value("3"), new Value("4")));
        assertThat(PointsGenerator.makePoints("(1,2)-(3,4)")).isEqualTo(testPoints);
    }
}
