package coordinatecalculator.domain;

import coordinatecalculator.view.inputview.PointParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    void 직사각형이_아닌_경우() {
        PointGroup points = new PointGroup(PointParser.getValidPoints("(0,0)-(0,1)-(1,0)-(1,2)"));

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(points);
        });
    }

    @Test
    void 넓이() {
        Rectangle answer2 = new Rectangle(PointGroupTest.rectangle);
        assertThat(answer2.area()).isEqualTo(1);
    }
}