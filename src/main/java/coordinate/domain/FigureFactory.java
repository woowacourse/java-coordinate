package coordinate.domain;

public class FigureFactory {
    public static Figure create(Points points) {
        if (points.size() == 3) {
            return new Triangle(points);
        }
        if (points.size() == 4) {
            return new Rectangle(points);
        }
        throw new IllegalArgumentException("올바른 점의 갯수를 입력 하세요");
    }
}
