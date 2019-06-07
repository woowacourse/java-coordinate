package calculator.domain.figure;

import java.util.*;

/**
 * @author soojinroh
 * @version 1.0 2019-05-22
 */
public class Coordinates implements Iterable<Coordinate>{
    private static final int MAX_COORDINATE = 4;
    private final List<Coordinate> coordinates;

    public Coordinates()  {
        this.coordinates = new ArrayList<>();
    }

    public void add(Coordinate coordinate) {
        checkDuplication(coordinate);
        coordinates.add(coordinate);
        checkMaxCoordinates();
    }

    private void checkDuplication(Coordinate coordinate) {
        String EX_DUPLICATED_COORDINATES_MESSAGE = "위치가 같은 점(point)이 존재합니다.";

        if (coordinates.contains(coordinate)) {
            throw new IllegalArgumentException(EX_DUPLICATED_COORDINATES_MESSAGE);
        }
    }

    private void checkMaxCoordinates() {
        String EX_MAX_COORDINATES_COUNT_MESSAGE = "4개 이하의 좌표를 입력해주세요.";

        if (coordinates.size() > MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_MAX_COORDINATES_COUNT_MESSAGE);
        }
    }

    public int size() {
        return coordinates.size();
    }

    public Coordinate get(int index) {
        return coordinates.get(index);
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return coordinates.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates points1 = (Coordinates) o;
        return Objects.equals(coordinates, points1.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
