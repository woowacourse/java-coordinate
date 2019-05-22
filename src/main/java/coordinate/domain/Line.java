package coordinate.domain;


public class Line extends Figure implements Comparable<Line>{
    private Double length;

    public Line(Double length) {
        this.length = length;
    }

    @Override
    double findArea() {
        return 0;
    }

    @Override
    public int compareTo(Line o) {
        return Double.compare(o.length,length);
    }
}
