package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
class LineTest {

    AbstractFigure abstractFigure;
    Points points;
    FigureType figureType;

    @BeforeEach
    void setUp() {
        points = new Points();
        points.add(new Point(8, 21));
        points.add(new Point(16, 3));
        figureType = FigureType.valueOf(points);
        abstractFigure = new FigureFactory().create(figureType);
    }

    @Test
    void create_계산_정답() {
        assertThat(abstractFigure.perimeter()).isEqualTo(19.697, offset(0.00099));
    }

    @Test
    void line_계산_반올림_확인() {
        assertThat(abstractFigure.perimeter()).isEqualTo(19.698, offset(0.00099));
    }

    @Test
    void create_Point로_생성() {
        Line line = new Line(new Point(8, 21), new Point(16, 3));
        assertThat(line.perimeter()).isEqualTo(abstractFigure.perimeter(), offset(0.00099));
    }

    @Test
    void comparable_확인() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(new Point(0,0), new Point(0,2)));
        lines.add(new Line(new Point(0,0), new Point(0,1)));
        lines.add(new Line(new Point(0,0), new Point(0,3)));
        Collections.sort(lines);
        assertThat(lines.get(0).perimeter()).isEqualTo(1, offset(0.00099));
    }
}