package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointGroupTest {
    static PointGroup line = new PointGroup("(0,0)-(1,1)");
    static PointGroup triangle = new PointGroup("(0,0)-(0,1)-(1,0)");
    static PointGroup rectangle = new PointGroup("(0,0)-(0,1)-(1,0)-(1,1)");

    @Test
    void 올바른_입력1() {
        List<Point> answer = Arrays.asList(Point.of(0,0), Point.of(1,1));
        assertThat(line.getPoints()).isEqualTo(answer);
    }

    @Test
    void 올바른_입력2() {
        List<Point> points = Collections.singletonList(Point.of(0, 0));
        assertThat(new PointGroup("(0,0)").getPoints()).isEqualTo(points);
    }

    @Test
    void 입력_패턴_불일치() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointGroup("0,0-1,1");
        });
    }

    @Test
    void 좌표가_정수가_아닌_경우() {
        assertThrows(NumberFormatException.class, () -> {
            new PointGroup("(0,0)-(1,a)");
        });
    }

    @Test
    void 중복된_좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PointGroup("(0,0)-(0,0)");
        });
    }
}