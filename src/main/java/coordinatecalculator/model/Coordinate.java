package coordinatecalculator.model;

public class Coordinate {
    private static final int MIN_COORDINATE_VALUE = 0;
    private static final int MAX_COORDINATE_VALUE = 24;

    private final XValue xValue;
    private final YValue yValue;

    public Coordinate(int x, int y) {
        checkCoordinateRange(x);
        checkCoordinateRange(y);

        this.xValue = new XValue(x);
        this.yValue = new YValue(y);
    }

    private void checkCoordinateRange(int coordinateValue) {
        if ((coordinateValue < MIN_COORDINATE_VALUE)|| (coordinateValue > MAX_COORDINATE_VALUE)) {
            throw new IllegalArgumentException(MIN_COORDINATE_VALUE + "에서 " + MAX_COORDINATE_VALUE + "사이 값을 입력해주세요.");
        }
    }


    public int getXValue(){
        return xValue.getXValue();
    }

    public int getYValue(){
        return yValue.getYValue();
    }
}
