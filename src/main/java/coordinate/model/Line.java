package coordinate.model;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String OUTPUT_AREA_OF_LINE = "두 점 사이의 거리는 ";

    Line(List<Point> points) {
        super(points);
    }

    @Override
    public double area() {
        return getPoints().get(0).calculateDistance(getPoints().get(1));
    }

    @Override
    public String getAreaInfo() {
        return OUTPUT_AREA_OF_LINE + area();
    }
}
