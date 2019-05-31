package coordinatecalculator.domain;

import coordinatecalculator.view.inputview.PointParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {
    @Test
    void 좌표가_한_줄에_있는_경우() {
        PointGroup points = new PointGroup(PointParser.getValidPoints("(0,0)-(1,1)-(2,2)"));

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(points);
        });
    }

    @Test
    void 넓이() {
        Triangle triangle = new Triangle(PointGroupTest.triangle);
        assertThat(triangle.area()).isEqualTo(0.5, offset(0.001));
    }
}