package coordinate.domain;

public class FigureFactory {
    public static Figure generateFigure(PointList pointList) {
        if (pointList.getSize() == 3) {
            return new Triangle(pointList.findLine());
        }
        if (pointList.getSize() == 4) {
            return new Square(pointList.findLine());
        }
        return new Line(pointList);
    }
}
