package location.domain;

public class FigureMaker {
    public static Figure create(Points points) {
        return FigureEnum.valueOf(points.size()).create(points);
    }
}
