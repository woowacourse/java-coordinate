package coordinatecalculator.model;

public class Point {
    private Value xVal;
    private Value yVal;

    public Point(String xCoordinate, String yCoordinate) {
        this.xVal = Value.retrieveValue(Integer.parseInt(xCoordinate));
        this.yVal = Value.retrieveValue(Integer.parseInt(yCoordinate));
    }
}
