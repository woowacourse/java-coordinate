package coordinate.domain;


import java.util.Arrays;
import java.util.function.Function;

public enum FigureFactory {
    LINE(Line.COUNT_OF_POINT, Line::new),
    TRIANGLE(Triangle.COUNT_OF_POINT, Triangle::new),
    RECTANGLE(Rectangle.COUNT_OF_POINT, Rectangle::new);

    private int countOfPoint;
    private Function<Points, Figure> mapper;

    FigureFactory(int countOfPoint, Function<Points, Figure> mapper) {
        this.countOfPoint = countOfPoint;
        this.mapper = mapper;
    }

    public Figure mapToShape(Points points) {
        return mapper.apply(points);
    }

    public static Figure generateFigure(Points points) {
        FigureFactory result =  Arrays.stream(values())
                .filter(figure -> figure.countOfPoint == points.getSize())
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("만들 수 있는 도형이 없습니다."));
        return result.mapToShape(points);
    }

}
