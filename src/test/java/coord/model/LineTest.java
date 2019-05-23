package coord.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LineTest {
    @Test
    void lengthTest() {
        assertEquals(15.811, new Line(new Point(1, 4), new Point(6, 19)).length(), 0.001);
    }

    @Test
    void gradientTest() {
        assertEquals(4.0, new Line(new Point(1, 4), new Point(2, 8)).gradient(), 0.001);
    }

    @Test
    void sortTestA() {
        assertEquals(2, new Line(new Point(4, 8), new Point(2, 3)).P.x);
    }

    @Test
    void sortTestB() {
        assertEquals(10, new Line(new Point(15, 5), new Point(10, 10)).P.x);
    }

    @Test
    void includesTestA() {
        assertEquals(true, new Line(new Point(1, 2), new Point(4, 8)).includes(new Point(2, 4)));
    }

    @Test
    void includesTestB() {
        assertEquals(true, new Line(new Point(4, 8), new Point(1, 2)).includes(new Point(2, 4)));
    }

    @Test
    void includesTestC() {
        assertEquals(true, new Line(new Point(4, 8), new Point(1, 2)).includes(new Point(1, 2)));
    }

    @Test
    void connectionTestA()  {
        assertEquals(true, new Line(new Point(0, 0), new Point(20, 20)).isConnectedTo(new Line(new Point(0, 0), new Point(2, 7))));
    }

    @Test
    void connectionTestB()  {
        assertEquals(true, new Line(new Point(5, 5), new Point(10, 10)).isConnectedTo(new Line(new Point(15, 5), new Point(10, 10))));
    }
}