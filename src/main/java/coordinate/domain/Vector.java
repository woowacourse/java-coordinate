package coordinate.domain;

import static coordinate.util.NotNullValidator.validateNotNull;

public class Vector {

    private final int x;
    private final int y;

    public Vector(Line line) {
        validateNotNull(line);
        Point p1 = line.getStartPoint();
        Point p2 = line.getEndPoint();

        this.x = p2.getX() - p1.getX();
        this.y = p2.getY() - p1.getY();
    }

    public int innerProduct(Vector another) {
        return x * another.x + y * another.y;
    }

    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
