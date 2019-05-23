package calculator.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @author heebg
 * @version 1.0 2019-05-22
 */
public class Coordinates implements Iterable<Coordinate>{
    private static final String EX_DUPLICATED_COORDINATES_MESSAGE = "위치가 같은 점(point)이 존재합니다.";
    public static final String EX_MAX_COORDINATES_COUNT_MESSAGE = "4개 이하의 좌표를 입력해주세요.";
    public static final int MAX_COORDINATE = 4;
    private final List<Coordinate> coordinates;

    /**
     * 생성자
     */
    public Coordinates()  {
        this.coordinates = new ArrayList<>();
    }

    /**
     * Coordinate 추가
     * <br> 중복된 Coordinate 추가 시 예외 발생
     *
     * @param coo 추가할 Coordinate
     * @throws IllegalArgumentException
     */
    public void add(Coordinate coo) {
        checkDuplication(coo);
        checkMaxCoordinates();

        coordinates.add(coo);
    }

    private void checkDuplication(Coordinate coordinate) {
        if (coordinates.contains(coordinate)) {
            throw new IllegalArgumentException(EX_DUPLICATED_COORDINATES_MESSAGE);
        }
    }

    private void checkMaxCoordinates() {
        if (coordinates.size() >= MAX_COORDINATE) {
            throw new IllegalArgumentException(EX_MAX_COORDINATES_COUNT_MESSAGE);
        }
    }

    /**
     * 크기 반환
     *
     * @return coordinates.size
     */
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
