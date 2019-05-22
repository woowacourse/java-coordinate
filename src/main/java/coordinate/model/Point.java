package coordinate.model;

public class Point implements Comparable<Point>{
    private PointNumber x;
    private PointNumber y;

    public Point(PointNumber x, PointNumber y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point point2) {
        return Math.sqrt(Math.pow(this.x.getNumber() - point2.x.getNumber(), 2)
        + Math.pow(this.y.getNumber() - point2.y.getNumber(), 2));
    }

    public boolean isEqualX(Point anotherPoint) {
        return this.x.getNumber() == anotherPoint.x.getNumber();
    }

    public boolean isEqualY(Point anotherPoint) {
        return this.y.getNumber() == anotherPoint.y.getNumber();
    }

    @Override
    public int compareTo(Point o) {
        if(x.getNumber() == o.x.getNumber()){
            return y.getNumber() - o.y.getNumber();
        }
        return x.getNumber() - o.x.getNumber();
    }
}
