package coordinate.model.creator;

import coordinate.model.Point;
import coordinate.model.Value;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class VerticesGeneratorTest {

    @Test
    void 포인트_생성_테스트() {
        List<Point> testPoints = Arrays.asList(new Point(new Value(1), new Value(2)),
                new Point(new Value(3), new Value(4)));
        AssertionsForClassTypes.assertThat(VerticesGenerator.makePoints("(1,2)-(3,4)").equals(testPoints));
    }
    @Test
    void 포인트_중복_테스트() {
        assertThrows(IllegalArgumentException.class,
                ()-> VerticesGenerator.makePoints("(1,1)-(1,1)"));
    }

}
