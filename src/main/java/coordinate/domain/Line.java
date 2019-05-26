package coordinate.domain;

public class Line extends AbstractFigure {

    Line(Points points) {
        super(points);
    }

    @Override
    public double calculateArea() {
        return points.getPoint(0).calculateLength(points.getPoint(1));
    }

    @Override
    public String getResult() {
        return "두 점 사이의 거리는 %.2f 입니다.";
    }

}
