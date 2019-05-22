package coordinatecalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    //    @Test
    //    void getLength() {
    //    }
    //
    //    @Test
    //    void compareTo() {
    //    }

    @Test
    void toString1() {
        String expected = "Line {start: Point {x: 0, y: 0}, end: Point {x: 10, y: 10}, length: 14.142135623730951}";
        Point p1 = new Point(0, 0);
        Point p2 = new Point(10, 10);
        Line line = new Line(p1, p2);
        assertThat(line.toString()).isEqualTo(expected);
    }

    @Test
    void lineAbove() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(10, 10);
        Point p3 = new Point(4, 8);
        Point p4 = new Point(6, 2);
        Point p5 = new Point(10, 0);
        Point p6 = new Point(0, 10);
        Point p7 = new Point(5, 5);
        Point p8 = new Point(3, 7);
        Line line = new Line(p1, p2);
        assertThat(line.aboveOrBelowPoint(p3)).isEqualTo(Line.bisect.ABOVE);
        assertThat(line.aboveOrBelowPoint(p4)).isEqualTo(Line.bisect.BELOW);
        assertThat(line.aboveOrBelowPoint(p7)).isEqualTo(Line.bisect.SAME);
        line = new Line(p2, p1);
        assertThat(line.aboveOrBelowPoint(p3)).isEqualTo(Line.bisect.ABOVE);
        assertThat(line.aboveOrBelowPoint(p4)).isEqualTo(Line.bisect.BELOW);
        assertThat(line.aboveOrBelowPoint(p7)).isEqualTo(Line.bisect.SAME);
        line = new Line(p5, p6);
        assertThat(line.aboveOrBelowPoint(p3)).isEqualTo(Line.bisect.ABOVE);
        assertThat(line.aboveOrBelowPoint(p4)).isEqualTo(Line.bisect.BELOW);
        assertThat(line.aboveOrBelowPoint(p8)).isEqualTo(Line.bisect.SAME);
    }
}