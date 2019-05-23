package coordinatecalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SegmentTest {

    //    @Test
    //    void getLength() {
    //    }
    //
    //    @Test
    //    void compareTo() {
    //    }

    @Test
    void toString1() {
        String expected = "Segment {start: Point {x: 0, y: 0}, end: Point {x: 10, y: 10}, length: 14.142135623730951}";
        Point p1 = new Point(0, 0);
        Point p2 = new Point(10, 10);
        Segment segment = new Segment(p1, p2);
        assertThat(segment.toString()).isEqualTo(expected);
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
        Segment segment = new Segment(p1, p2);
        assertThat(segment.aboveOrBelowPoint(p3)).isEqualTo(Segment.bisect.ABOVE);
        assertThat(segment.aboveOrBelowPoint(p4)).isEqualTo(Segment.bisect.BELOW);
        assertThat(segment.aboveOrBelowPoint(p7)).isEqualTo(Segment.bisect.SAME);
        segment = new Segment(p2, p1);
        assertThat(segment.aboveOrBelowPoint(p3)).isEqualTo(Segment.bisect.ABOVE);
        assertThat(segment.aboveOrBelowPoint(p4)).isEqualTo(Segment.bisect.BELOW);
        assertThat(segment.aboveOrBelowPoint(p7)).isEqualTo(Segment.bisect.SAME);
        segment = new Segment(p5, p6);
        assertThat(segment.aboveOrBelowPoint(p3)).isEqualTo(Segment.bisect.ABOVE);
        assertThat(segment.aboveOrBelowPoint(p4)).isEqualTo(Segment.bisect.BELOW);
        assertThat(segment.aboveOrBelowPoint(p8)).isEqualTo(Segment.bisect.SAME);
    }
}