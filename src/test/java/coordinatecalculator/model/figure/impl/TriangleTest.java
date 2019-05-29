package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import coordinatecalculator.model.figure.impl.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TriangleTest {
    @Test
    void 삼각형_넓이_구하기() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(20, 10);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);
        assertThat(new Triangle(coordinates).calculateArea()).isEqualTo(50);
    }

    @Test
    void 매우_작은_삼각형인_경우() {
        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(0, 1);
        Coordinate c3 = new Coordinate(1, 0);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);
        assertThat(new Triangle(coordinates).calculateArea()).isEqualTo(0.5);
    }

    @Test
    void 극적인_둔각_삼각형인_경우() {
        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(24, 0);
        Coordinate c3 = new Coordinate(12, 1);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);
        assertThat(new Triangle(coordinates).calculateArea()).isEqualTo(12);
    }

    @Test
    void 극적인_예각_삼각형인_경우() {
        Coordinate c1 = new Coordinate(0, 0);
        Coordinate c2 = new Coordinate(2, 0);
        Coordinate c3 = new Coordinate(1, 24);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);
        assertThat(new Triangle(coordinates).calculateArea()).isEqualTo(24);
    }
}
