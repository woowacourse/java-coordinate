package coord.model.figure;

public class ConvexPolygon extends Figure {
    protected ConvexPolygon(Points points) {
        super(points);
    }

    @Override
    public double area() {
        if (Double.compare(areaCache, .0) == 0) {
            areaCache = area(.0, 0);
        }
        return areaCache;
    }

    private double area(double result, int i) {
        if (i + 2 == points.number()) {
            return result;
        }
        return area(result + new Triangle(points.get(0), points.get(i + 1), points.get(i + 2)).area(), i + 1);
    }
}