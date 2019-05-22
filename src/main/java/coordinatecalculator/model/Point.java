package coordinatecalculator.model;


public class Point {
    private final XPoint xPoint;
    private final YPoint yPoint;

    public Point(String xPoint, String yPoint) {
        this.xPoint = new XPoint(xPoint);
        this.yPoint = new YPoint(yPoint);
    }

}
