package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {

    @Test
    void 삼각형이_맞는지_검증_테스트() {
        Points points = new Points("(1,1)-(3,1)-(3,3)".split("-"));
        assertDoesNotThrow(() -> new Triangle(points));
    }

    @Test
    void 삼각형이_아닐때_검증_테스트() {
        Points points = new Points("(1,1)-(3,1)-(5,1)".split("-"));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(points));
    }

    @Test
    void 삼각형_넓이_구하는_테스트() {
        Points points = new Points("(1,1)-(3,1)-(3,3)".split("-"));
        assertThat(new Triangle(points).area()).isEqualTo(2);
    }
}
