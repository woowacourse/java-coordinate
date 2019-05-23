package calculator.domain;

import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class Coordinate  {
    private static final String EX_COORDINATE_RANGE_MESSAGE = "좌표 범위는 0~24 사이입니다.";
    private static final int NOT_MATCH = -1;
    private static final int MIN_COORDINATE = 0;
    private static final int MAX_COORDINATE = 24;
    private final int xCoordinate;
    private final int yCoordinate;

    private Coordinate(int xCoordinate, int yCoordinate) {
        this.xCoordinate = checkXCoordinateRange(xCoordinate);
        this.yCoordinate = checkYCoordinateRange(yCoordinate);
    }

    /**
     * 생성자
     *
     * @param xCoordinate x좌표
     * @param yCoordinate y좌표
     * @return Coordinate
     */
    public static Coordinate create(int xCoordinate, int yCoordinate) {
        return new Coordinate(xCoordinate, yCoordinate);
    }

    private int checkXCoordinateRange(int xCoordinate) {
        if(xCoordinate < MIN_COORDINATE || xCoordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_COORDINATE_RANGE_MESSAGE);
        }

        return xCoordinate;
    }

    private int checkYCoordinateRange(int yCoordinate) {
        if(yCoordinate < MIN_COORDINATE || yCoordinate > MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_COORDINATE_RANGE_MESSAGE);
        }

        return yCoordinate;
    }

    /**
     * y좌표가 맞으면 x좌표 반환
     * <br> 맞지 않으면 -1 반환
     *
     * @param yCoordinate y좌표
     * @return xCoordinate
     */
    public int matchYAxis(int yCoordinate) {
        if (yCoordinate == this.yCoordinate) {
            return xCoordinate;
        }

        return NOT_MATCH;
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate point = (Coordinate) o;
        return xCoordinate == point.xCoordinate &&
                yCoordinate == point.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
