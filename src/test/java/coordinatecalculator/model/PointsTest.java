package coordinatecalculator.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {

    private Points points;

    @BeforeEach
    void setUp() {
        points = new Points("(1,1)-(2,2)".split("-"));
    }

    @Test
    void 점_생성_테스트() {
        assertThat(points.getPointByIndex(0)).isEqualTo(new Point("(1,1)"));
        assertThat(points.getPointByIndex(1)).isEqualTo(new Point("(2,2)"));
    }

    @Test
    void 잘못된_점_생성_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Points(new String[]{"((1,1)"}));
    }

    @Test
    void 중복된_점_생성_테스트() {
        assertThrows(IllegalArgumentException.class, () ->new Points("(1,1)-(1,1)".split("-")));
    }

    @AfterEach
    void tearDown() {
        points = null;
    }
}
