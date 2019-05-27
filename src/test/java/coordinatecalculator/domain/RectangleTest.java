package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    void create() {
        Points points = new Points(Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("0", "1"), new Point("1", "1")));
        assertThat(new Rectangle(points)).isEqualTo(new Rectangle(points));
    }

    @Test
    void 넓이_계산() {
        Points points = new Points(Arrays.asList(new Point("1", "1"), new Point("5", "1"), new Point("1", "11"), new Point("5", "11")));
        Rectangle rectangle = new Rectangle(points);
        assertEquals(40, rectangle.calculateResult(), 0.001);
    }

    @Test
    void 이웃한_변이_서로_수직이_아닌_경우() {
        Points points = new Points(Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("1", "1"), new Point("2", "1")));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    void 마주보는_변이_평행이_아닌_경우() {
        Points points = new Points(Arrays.asList(new Point("1", "1"), new Point("3", "1"), new Point("1", "2"), new Point("3", "3")));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }
}
