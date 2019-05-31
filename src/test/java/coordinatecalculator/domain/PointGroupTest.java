package coordinatecalculator.domain;

import coordinatecalculator.view.inputview.PointParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointGroupTest {
    static Point zero_zero = Point.of(0, 0);
    static Point zero_one = Point.of(0, 1);
    static Point one_zero = Point.of(1, 0);
    static Point one_one = Point.of(1, 1);

    static PointGroup line = new PointGroup(Arrays.asList(zero_zero, one_one));
    static PointGroup triangle = new PointGroup(Arrays.asList(zero_zero, zero_one, one_zero));
    static PointGroup rectangle = new PointGroup(Arrays.asList(zero_zero, zero_one, one_zero, one_one));

    @Test
    void 중복된_좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointGroup(Arrays.asList(zero_zero, zero_zero));
        });
    }

    @Test
    void 좌표_정렬() {
        PointGroup points = new PointGroup(PointParser.getValidPoints("(0,1)-(1,0)-(1,1)-(0,0)"));
        assertThat(points).isEqualTo(rectangle);
    }
}