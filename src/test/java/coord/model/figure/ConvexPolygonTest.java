package coord.model.figure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConvexPolygonTest {
    @Test
    void initTestA() {
        assertThatThrownBy(() -> ConvexPolygonFactory.makeFrom(new Point(1, 2), new Point(2, 4), new Point(4, 8)));
    }

    @Test
    void initTestB() {
        ConvexPolygonFactory.makeFrom(new Point(1, 2), new Point(2, 4), new Point(4, 8), new Point(6, 5));
    }

    @Test
    void initTestC() {
        ConvexPolygonFactory.makeFrom(new Point(10, 10), new Point (10, 0), new Point(5, 5), new Point (15, 5));
    }

    @Test
    void initTestD() {
        assertThatThrownBy(() -> {
            ConvexPolygonFactory.makeFrom(new Point(0, 10), new Point (10, 0), new Point(0, 0), new Point (2, 3));
        });
    }

    @Test
    void areaTestA() {
        assertThat(ConvexPolygonFactory.makeFrom(
                new Point(1, 10), new Point(1, 1), new Point (5, 1), new Point (5, 10)).area()
        ).isCloseTo(36.0, offset(0.0000001));
    }
     @Test
    void areaTestB() {
        assertThat(ConvexPolygonFactory.makeFrom(
                new Point(10, 10), new Point (10, 0), new Point(5, 5), new Point (15, 5)).area()
        ).isCloseTo(50.0, offset(0.0000001));
    }

    @Test
    void areaTestC() {
        assertThat(ConvexPolygonFactory.makeFrom(
                new Point(0, 0),
                new Point (8, 9),
                new Point(4, 7),
                new Point (10, 6),
                new Point(7, 3),
                new Point(1, 0)).area()
        ).isCloseTo(38.5, offset(0.0000001));
    }
}