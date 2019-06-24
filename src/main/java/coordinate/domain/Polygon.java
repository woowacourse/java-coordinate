package coordinate.domain;

import java.util.Set;

import static coordinate.util.NotNullValidator.validateNotNull;

public abstract class Polygon extends Figure implements AreaCalculable {
    private Lines lines;

    Polygon(Lines lines) {
        this.lines = lines;
        validateNotNull(lines);
    }

    /**
     * 평행사변형의 넓이를 구한다.
     */
    public double areaOfParallelogram() {
        Vector v1 = lines.getVector(0);
        Vector v2 = lines.getVector(lines.getSize() - 1);
        v2 = v2.invert();

        return Math.sqrt(Math.pow(v1.length(), 2) * Math.pow(v2.length(), 2) - Math.pow(v1.innerProduct(v2), 2));
    }

    @Override
    public double length() {
        return lines.sumLength();
    }

    @Override
    public Set<Point> getPoints() {
        return lines.getPoints();
    }
}
