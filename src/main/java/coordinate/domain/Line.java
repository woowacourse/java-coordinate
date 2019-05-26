package coordinate.domain;

public class Line extends AbstractFigure {
    static final int COUNT_OF_POINT = 2;

    Line(Points points) {
        super(points);
    }

    @Override
    public double calculateArea() {
        return points.getPoint(FIRST_POINT).calculateLength(points.getPoint(SECOND_POINT));
    }

    @Override
    public String getResult() {
        return "두 점 사이의 거리는 %.2f 입니다.";
    }

}
