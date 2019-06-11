package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointParserTest {
    @Test
    void 포인트_리스트를_제대로_반환하는지_테스트() {
        assertThat(PointParser.parse("(1,2)-(3,4)"))
                .isEqualTo(Arrays.asList(new Point(1, 2), new Point(3, 4)));
    }

    @Test
    void 소괄호로_둘러쌓여_있지않은경우_에러를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> PointParser.parse("(1,2)-3,4)"));
    }
}