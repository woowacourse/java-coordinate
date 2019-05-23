package coordinatecalculator;

class Triangle extends Polygon {
    Triangle(Point a, Point b, Point c) {
        points.add(a);
        points.add(b);
        points.add(c);
        segments = makeSegment(this.points);
    }

    @Override
    public double area() {
        double a = segments.get(0).getLength();
        double b = segments.get(1).getLength();
        double c = segments.get(2).getLength();
        return heronFormula(a, b, c);
    }
}
