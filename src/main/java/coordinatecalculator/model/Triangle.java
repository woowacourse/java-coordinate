package coordinatecalculator.model;

public class Triangle implements Figure {
    private double distance;

    public Triangle(final Points points){
//        this.distance = points.getDistance(0, 1).getDistance();
    }

    @Override
    public double getResult() {
        return distance;
    }
}
