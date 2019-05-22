package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 사각형_넓이_구하기() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(20, 10);
        Coordinate c4 = new Coordinate(20, 20);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3, c4);
        assertThat(new Rectangle(coordinates).calculateArea()).isEqualTo(100);
    }

    @Test
    void 직사각형이_아닌_경우() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(20, 10);
        Coordinate c4 = new Coordinate(20, 21);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3, c4);
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(coordinates));
    }
}
