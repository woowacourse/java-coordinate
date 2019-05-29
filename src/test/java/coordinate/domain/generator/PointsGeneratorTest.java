package coordinate.domain.generator;

import coordinate.domain.Point;
import coordinate.domain.Points;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointsGeneratorTest {

    @Test
    void 대쉬_구분자_없는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> PointsGenerator.generatePoints("(1,2)(3,4)"));
    }

    @Test
    void Points_생성_테스트() {
        assertThat(PointsGenerator.generatePoints("(1,2)-(3,4)"))
                .isEqualTo(Points.of(Arrays.asList(new Point(1, 2), new Point(3, 4))));
    }

    @Test
    void 점_갯수_2개_테스트() {
        assertThat(PointsGenerator.generatePoints("(1,2)-(3,4)").size()).isEqualTo(2);
    }

    @Test
    void 점_갯수_3개_테스트() {
        assertThat(PointsGenerator.generatePoints("(1,2)-(3,4)-(5,6)").size()).isEqualTo(3);
    }

    @Test
    void 점_갯수_4개_테스트() {
        assertThat(PointsGenerator.generatePoints("(1,2)-(3,4)-(5,6)-(5,9)").size()).isEqualTo(4);
    }
}