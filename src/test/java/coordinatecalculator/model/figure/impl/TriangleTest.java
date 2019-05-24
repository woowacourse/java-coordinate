package coordinatecalculator.model.figure.impl;

import coordinatecalculator.model.coordinate.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TriangleTest {
    @Test
    void 삼각형_넓이_구하기() {
        Coordinate c1 = new Coordinate(10, 10);
        Coordinate c2 = new Coordinate(10, 20);
        Coordinate c3 = new Coordinate(20, 10);
        List<Coordinate> coordinates = Arrays.asList(c1, c2, c3);
        assertThat(new Triangle(coordinates).calculateArea()).isEqualTo(50);
    }
}
