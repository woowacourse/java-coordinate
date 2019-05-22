package coordinatecalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ShapeTest {
    Point a;
    Point b;
    Point c;
    Point d;
    Point e;
    Shape shape;

    @Test
    void insufficientPoints() {
        a = new Point(10, 10);
        b = new Point(15, 15);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Shape(a, b);
        });
    }

    @Test
    void duplicationAware() {
        a = new Point(1, 1);
        b = new Point(2, 2);
        c = new Point(2, 2);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Shape(a, b, c);
        });
    }

    @Test
    void area() {
        a = new Point(2, 1);
        b = new Point(4, 5);
        c = new Point(7, 8);
        shape = new Shape(a, b, c);
        assertThat(shape.area()).isEqualTo(3);

        a = new Point(5, 5);
        b = new Point(10, 10);
        c = new Point(5, 10);
        d = new Point(10, 5);
        shape = new Shape(a, b, c, d);
        assertThat(shape.area()).isEqualTo(25);

        a = new Point(3, 4);
        b = new Point(5, 11);
        c = new Point(12, 8);
        d = new Point(9, 5);
        e = new Point(5, 6);
        shape = new Shape(a, b, c, d, e);
        assertThat(shape.area()).isEqualTo(30);
    }
}
